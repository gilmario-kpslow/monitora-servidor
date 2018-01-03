package br.gov.ce.caucaia.sefin.dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gilmario
 * @param <T>
 * @param <PK>
 */
public abstract class DAO<T, PK extends Serializable> implements Serializable {

    @PersistenceContext
    private EntityManager manager;

    public EntityManager getEm() {
        return manager;
    }
    
    public T salvar(T t) {
        getEm().persist(t);
        return t;
    }

    public T atualizar(T t) {
        return getEm().merge(t);
    }

    public void excluir(T t) {
        getEm().refresh(t);
        getEm().remove(t);
    }

    public T carregar(Class<T> entidade, Serializable pk) {
        return getEm().find(entidade, pk);
    }
}
