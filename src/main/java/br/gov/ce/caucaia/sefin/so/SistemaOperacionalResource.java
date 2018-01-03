package br.gov.ce.caucaia.sefin.so;

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
@Path("/so")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Provider
public class SistemaOperacionalResource implements Serializable {

    @EJB
    private SistemaOperacionalServico servico;

    @GET
    public Response getServidores() {
        try {
            return Response.ok(servico.buscar()).build();
        } catch (Exception e) {
            return Response.accepted("ERROR").status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getServidor(@PathParam(value = "id") Long id) {
        try {
            return Response.ok(servico.carregar(id)).build();
        } catch (Exception e) {
            return Response.accepted("ERROR").status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path(value = "/{limit}/{offset}")
    public Response getServidoresFiltro(@PathParam(value = "limit") Integer limit,@PathParam(value = "offset") Integer offset ) {
        try {
            return Response.ok(servico.buscar(limit, offset)).build();
        } catch (Exception e) {
            return Response.accepted("ERROR").status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    public Response add(SistemaOperacional so) {
        try {
            servico.salvar(so);
            return Response.ok(so).build();
        } catch (Exception e) {
            return Response.accepted("ERROR").status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    public Response update(SistemaOperacional so) {
        try {
            servico.atualizar(so);
            return Response.ok(so).build();
        } catch (Exception e) {
            return Response.accepted("ERROR").status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path(value = "{id}")
    public Response remove(@PathParam(value = "id") Long id) {
        try {
            servico.excluir(id);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.accepted("ERROR").status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
