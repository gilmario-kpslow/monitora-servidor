/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ce.caucaia.sefin;

import br.gov.ce.caucaia.sefin.entidade.EstatisticaServico;
import br.gov.ce.caucaia.sefin.entidade.Servico;
import br.gov.ce.caucaia.sefin.servico.EstatisticaServicoServico;
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
public class OcorrenciaServico implements Serializable {

    @EJB
    private EstatisticaServicoServico servico;
    private List<EstatisticaServico> lista;

    public void atualizarLista(Servico s) {
        lista = servico.buscar(s);
    }

    public List<EstatisticaServico> getLista() {
        return lista;
    }

    public void setLista(List<EstatisticaServico> lista) {
        this.lista = lista;
    }

}
