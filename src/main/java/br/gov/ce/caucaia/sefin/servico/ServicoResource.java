package br.gov.ce.caucaia.sefin.servico;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
@Path("/servico")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Provider
public class ServicoResource implements Serializable {

    @EJB
    private ServicoServico servico;

    @GET
    @Path(value = "{servidor}")
    public Response getServicos(@PathParam(value = "servidor") Long id) {
        try {
            return Response.ok(servico.buscar(id)).build();
        } catch (Exception e) {
            return Response.accepted("ERROR").status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    public Response add(Servico servico) {
        try {
            this.servico.salvar(servico);
            return Response.ok(servico).build();
        } catch (Exception e) {
            return Response.accepted("ERROR").status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    public Response update(Servico servico) {
        try {
            this.servico.atualizar(servico);
            return Response.ok(servico).build();
        } catch (Exception e) {
            return Response.accepted("ERROR").status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path(value = "{id}")
    public Response remove(@PathParam(value = "id") Long id) {
        try {
            this.servico.excluir(id);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.accepted("ERROR").status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
