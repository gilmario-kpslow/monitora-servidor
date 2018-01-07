/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ce.caucaia.sefin.processador;

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
public class ProcessadorServico implements ServicoInterface<Processador>, Serializable {

    @EJB
    private ProcessadorDAO dao;

    @Override
    public void excluir(Serializable t) {
        Processador p = carregar(t);
        dao.excluir(p);
    }

    public void excluir(Long id) {
        Processador t = carregar(id);
        dao.excluir(t);
    }

    @Override
    public void atualizar(Processador t) {
        dao.atualizar(t);
    }

    @Override
    public void salvar(Processador t) {
        dao.salvar(t);
    }

    @Override
    public Processador carregar(Serializable pk) {
        return dao.carregar(Processador.class, pk);
    }

    @Override
    public List<Processador> listar() {
        return dao.listar();
    }

}
