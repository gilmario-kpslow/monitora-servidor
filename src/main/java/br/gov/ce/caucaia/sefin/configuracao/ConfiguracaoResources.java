/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ce.caucaia.sefin.configuracao;

import br.gov.ce.caucaia.sefin.infra.CrudResources;
import br.gov.ce.caucaia.sefin.infra.ServicoInterface;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author gilmario
 */
@Path("/conf")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Provider
public class ConfiguracaoResources extends CrudResources<Configuracao> implements Serializable {

    @EJB
    private ConfiguracaoServico servico;

    @Override
    public ServicoInterface<Configuracao> getServico() {
        return servico;
    }

}
