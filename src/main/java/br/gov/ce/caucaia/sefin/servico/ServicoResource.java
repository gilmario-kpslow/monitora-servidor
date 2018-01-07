package br.gov.ce.caucaia.sefin.servico;

import br.gov.ce.caucaia.sefin.infra.CrudResources;
import br.gov.ce.caucaia.sefin.infra.ServicoInterface;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author gilmario
 */
@Path("/servico")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Provider
public class ServicoResource extends CrudResources<Servico> implements Serializable {

    @EJB
    private ServicoServico servico;

    @Override
    public ServicoInterface<Servico> getServico() {
        return servico;
    }

}
