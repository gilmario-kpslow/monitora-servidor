package br.gov.ce.caucaia.sefin.servico;

import br.gov.ce.caucaia.sefin.dao.EstatisticaServidorDAO;
import br.gov.ce.caucaia.sefin.entidade.EstatisticaServidor;
import br.gov.ce.caucaia.sefin.entidade.Servidor;
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
public class EstatisticaServidorServico implements ServicoInterface<EstatisticaServidor>, Serializable {

    @EJB
    private EstatisticaServidorDAO dao;

    @Override
    public void excluir(EstatisticaServidor t) {
        dao.excluir(t);
    }

    @Override
    public void atualizar(EstatisticaServidor t) {
        dao.atualizar(t);
    }

    @Override
    public void salvar(EstatisticaServidor t) {
        dao.salvar(t);
    }

    @Override
    public EstatisticaServidor carregar(Serializable pk) {
        return dao.carregar(EstatisticaServidor.class, pk);
    }

    public void notificarAtivacao(Servidor s) {
        EstatisticaServidor es = new EstatisticaServidor();
        es.setDataHora(Calendar.getInstance());
        es.setDescricao("O Servidor foi iniciado");
        es.setServidor(s);
        salvar(es);
    }

    public void notificarDesativacao(Servidor s) {
        EstatisticaServidor es = new EstatisticaServidor();
        es.setDataHora(Calendar.getInstance());
        es.setDescricao("O Servidor parou");
        es.setServidor(s);
        salvar(es);
    }

    public void excluirTodas(Servidor t) {
        dao.excluirTodas(t);
    }

}
