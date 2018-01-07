package br.gov.ce.caucaia.sefin.infra;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author gilmario
 * @param <T>
 */
public interface ServicoInterface<T> {

    public void excluir(Serializable id);

    public void atualizar(T t);

    public void salvar(T t);

    public List<T> listar();

    public T carregar(Serializable pk);

}
