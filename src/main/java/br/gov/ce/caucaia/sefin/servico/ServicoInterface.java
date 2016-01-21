package br.gov.ce.caucaia.sefin.servico;

import java.io.Serializable;

/**
 *
 * @author gilmario
 * @param <T>
 */
public interface ServicoInterface<T> {

    public void excluir(T t);

    public void atualizar(T t);

    public void salvar(T t);

    public T carregar(Serializable pk);

}
