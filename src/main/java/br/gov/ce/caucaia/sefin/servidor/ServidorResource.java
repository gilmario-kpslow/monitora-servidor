package br.gov.ce.caucaia.sefin.servidor;

import br.gov.ce.caucaia.sefin.infra.CrudResources;
import br.gov.ce.caucaia.sefin.infra.ServicoInterface;
import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author gilmario
 */
@Path("/servidor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Provider
public class ServidorResource extends CrudResources<Servidor> implements Serializable {

    @EJB
    private ServidorServico servico;
    private final ExecutorService executorService = java.util.concurrent.Executors.newCachedThreadPool();

    @Override
    public ServicoInterface<Servidor> getServico() {
        return servico;
    }

    @GET
    @Path(value = "/{limit}/{offset}")
    public void getServidoresFiltro(@Suspended final AsyncResponse asyncResponse, @PathParam(value = "limit") final Integer limit, @PathParam(value = "offset") final Integer offset) {
        executorService.submit(() -> {
            asyncResponse.resume(doGetServidoresFiltro(limit, offset));
        });
    }

    private Response doGetServidoresFiltro(@PathParam(value = "limit") Integer limit, @PathParam(value = "offset") Integer offset) {
        try {
            return Response.ok(servico.buscar(limit, offset)).build();
        } catch (Exception e) {
            return Response.accepted("ERROR").status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
