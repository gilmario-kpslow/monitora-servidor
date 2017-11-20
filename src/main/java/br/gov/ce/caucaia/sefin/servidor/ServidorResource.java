/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ce.caucaia.sefin.servidor;

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
@Path("/servidor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Provider
public class ServidorResource implements Serializable {

    @EJB
    private ServidorServico servico;

    @GET
    public Response getServidores() {
        try {
            return Response.ok(servico.buscar()).build();
        } catch (Exception e) {
            return Response.accepted("ERROR").status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    public Response add(Servidor servidor) {
        try {
            servico.salvar(servidor);
            return Response.ok(servidor).build();
        } catch (Exception e) {
            return Response.accepted("ERROR").status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    public Response update(Servidor servidor) {
        try {
            servico.atualizar(servidor);
            return Response.ok(servidor).build();
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
