package br.gov.ce.caucaia.sefin.so;

import br.gov.ce.caucaia.sefin.infra.ServicoInterface;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
@LocalBean
public class SistemaOperacionalServico implements ServicoInterface<SistemaOperacional>, Serializable {

    @EJB
    private SistemaOperacionalDAO dao;

    @Override
    public void excluir(Serializable id) {
        SistemaOperacional t = carregar(id);
        dao.excluir(t);
    }

    public void excluir(Long id) {
        SistemaOperacional servidor = carregar(id);
        excluir(servidor);
    }

    @Override
    public void atualizar(SistemaOperacional t) {
        dao.atualizar(t);
    }

    @Override
    public void salvar(SistemaOperacional t) {
        dao.salvar(t);
    }

    @Override
    public SistemaOperacional carregar(Serializable pk) {
        return dao.carregar(SistemaOperacional.class, pk);
    }

    public Object buscar(Integer limit, Integer offset) {
        return dao.buscar(limit, offset);
    }

    @Override
    public List<SistemaOperacional> listar() {
        return dao.buscar();
    }

}
