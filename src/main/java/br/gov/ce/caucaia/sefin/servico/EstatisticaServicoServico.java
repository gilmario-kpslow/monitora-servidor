package br.gov.ce.caucaia.sefin.servico;

import br.gov.ce.caucaia.sefin.dao.EstatisticaServicoDAO;
import br.gov.ce.caucaia.sefin.entidade.EstatisticaServico;
import br.gov.ce.caucaia.sefin.entidade.Servico;
import java.io.Serializable;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
@LocalBean
public class EstatisticaServicoServico implements ServicoInterface<EstatisticaServico>, Serializable {

    @EJB
    private EstatisticaServicoDAO dao;

    @Override
    public void excluir(EstatisticaServico t) {
        dao.excluir(t);
    }

    @Override
    public void atualizar(EstatisticaServico t) {
        dao.atualizar(t);
    }

    @Override
    public void salvar(EstatisticaServico t) {
        dao.salvar(t);
    }

    @Override
    public EstatisticaServico carregar(Serializable pk) {
        return dao.carregar(EstatisticaServico.class, pk);
    }

    public void notificarAtivacao(Servico s) {
        EstatisticaServico es = new EstatisticaServico();
        es.setDataHora(Calendar.getInstance());
        es.setDescricao("O Servico foi ativado");
        es.setServico(s);
        salvar(es);
    }

    public void notificarDesativacao(Servico s) {
        EstatisticaServico es = new EstatisticaServico();
        es.setDataHora(Calendar.getInstance());
        es.setDescricao("O Servico parou");
        es.setServico(s);
        salvar(es);
    }

}
