package br.gov.ce.caucaia.sefin.so;

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
@Path("/so")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Provider
public class SistemaOperacionalResource extends CrudResources<SistemaOperacional> implements Serializable {

    @EJB
    private SistemaOperacionalServico servico;

    @Override
    public ServicoInterface<SistemaOperacional> getServico() {
        return servico;
    }

}
