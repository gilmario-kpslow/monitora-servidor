/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ce.caucaia.sefin.infra;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author gilmario
 * @param <T>
 */
public abstract class CrudResources<T> implements Serializable {

    public abstract ServicoInterface<T> getServico();
    private static final Logger LOG = Logger.getLogger(CrudResources.class.getName());

    @GET
    public Response getLista() {
        try {
            return Response.ok(getServico().listar()).build();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Erro", e);
            return Response.accepted("ERROR").status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getEntity(@PathParam(value = "id") Long id) {
        try {
            return Response.ok(getServico().carregar(id)).build();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Erro", e);
            return Response.accepted("ERROR").status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    public Response add(T t) {
        try {
            getServico().salvar(t);
            return Response.ok(t).build();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Erro", e);
            return Response.accepted("ERROR").status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    public Response update(T t) {
        try {
            getServico().atualizar(t);
            return Response.ok(t).build();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Erro", e);
            return Response.accepted("ERROR").status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path(value = "{id}")
    public Response remove(@PathParam(value = "id") Long id) {
        try {
            getServico().excluir(id);
            return Response.ok().build();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Erro", e);
            return Response.accepted("ERROR").status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
