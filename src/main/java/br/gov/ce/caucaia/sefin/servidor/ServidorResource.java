package br.gov.ce.caucaia.sefin.servidor;

import br.gov.ce.caucaia.sefin.infra.CrudResources;
import br.gov.ce.caucaia.sefin.infra.ServicoInterface;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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

    @GET
    @Path(value = "/{limit}/{offset}")
    public Response getServidoresFiltro(@PathParam(value = "limit") Integer limit, @PathParam(value = "offset") Integer offset) {
        try {
            return Response.ok(servico.buscar(limit, offset)).build();
        } catch (Exception e) {
            return Response.accepted("ERROR").status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ServicoInterface<Servidor> getServico() {
        return servico;
    }

}
