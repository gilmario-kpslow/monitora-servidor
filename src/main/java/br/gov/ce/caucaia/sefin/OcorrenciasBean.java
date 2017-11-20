package br.gov.ce.caucaia.sefin;

import br.gov.ce.caucaia.sefin.estatistica.EstatisticaServidor;
import br.gov.ce.caucaia.sefin.configuracao.EstatisticaServidorServico;
import br.gov.ce.caucaia.sefin.servidor.Servidor;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author gilmario
 */
@Named
@ViewScoped
public class OcorrenciasBean implements Serializable {

    @EJB
    private EstatisticaServidorServico servico;
    private List<EstatisticaServidor> lista;

    public void atualizaLista(Servidor servidor) {
        lista = servico.buscar(servidor);
    }

    public List<EstatisticaServidor> getLista() {
        return lista;
    }

    public void setLista(List<EstatisticaServidor> lista) {
        this.lista = lista;
    }

}
