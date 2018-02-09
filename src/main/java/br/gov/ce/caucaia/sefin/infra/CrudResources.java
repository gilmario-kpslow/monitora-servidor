/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ce.caucaia.sefin.infra;

import br.gov.ce.caucaia.sefin.Erro;
import br.gov.ce.caucaia.sefin.ValidacaoException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBTransactionRequiredException;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
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

    private final Validator validator;

    public CrudResources() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public abstract ServicoInterface<T> getServico();
    private static final Logger LOG = Logger.getLogger(CrudResources.class.getName());

    @GET
    public Response getLista() {
        try {
            return Response.ok(getServico().listar()).build();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Erro", e);
            return deuErro(e);
        }
    }

    @GET
    @Path("/{id}")
    public Response getEntity(@PathParam(value = "id") Long id) {
        try {
            return Response.ok(getServico().carregar(id)).build();
        } catch (EJBTransactionRequiredException e) {
            return Response.serverError().entity(e).status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Erro", e);
            return Response.accepted("ERROR").status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    public Response add(T t) {
        try {
            validar(t);
            getServico().salvar(t);
            return Response.ok(t).build();
        } catch (ValidacaoException e) {
            LOG.log(Level.SEVERE, "Erro", e);
            return Response.serverError().entity(e.getErros()).build();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Erro", e);
            return deuErro(e);
        }
    }

    protected Response deuErro(Exception e) {
        return Response.serverError().entity(new Erro[]{new Erro(getMensagemFrom(e), "ERRO")}).build();
    }

    private String getMensagemFrom(Throwable e) {
        if (Objects.nonNull(e.getCause())) {
            return getMensagemFrom(e.getCause());
        }
        return e.getLocalizedMessage();
    }

    private Set<ConstraintViolation<T>> validar(T t) throws ValidacaoException {
        Set<ConstraintViolation<T>> validadoes = validator.validate(t);
        if (validadoes.size() > 0) {
            List<Erro> erros = new ArrayList<>();
            validadoes.forEach(e -> {
                erros.add(new Erro(e.getMessage(), e.getPropertyPath().toString()));
            });
            throw new ValidacaoException(erros);
        }
        return validadoes;
    }

    @PUT
    public Response update(T t) {
        try {
            validar(t);
            getServico().atualizar(t);
            return Response.ok(t).build();
        } catch (ValidacaoException e) {
            LOG.log(Level.SEVERE, "Erro", e);
            return Response.serverError().entity(e.getErros()).build();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Erro", e);
            return deuErro(e);
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
            return deuErro(e);
        }
    }

}
