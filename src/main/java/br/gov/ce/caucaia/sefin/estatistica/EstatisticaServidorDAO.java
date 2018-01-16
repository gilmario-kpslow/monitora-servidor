package br.gov.ce.caucaia.sefin.estatistica;

import br.gov.ce.caucaia.sefin.infra.DAO;
import br.gov.ce.caucaia.sefin.infra.Repositorio;
import br.gov.ce.caucaia.sefin.servidor.Servidor;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
public class EstatisticaServidorDAO extends DAO<EstatisticaServidor, Long> implements Serializable {

    private Repositorio<EstatisticaServidor> repositorio;

    @PostConstruct
    private void init() {

    }

    public List<EstatisticaServidor> buscar(Servidor servidor) {
        try {
            return repositorio.listarPor(EstatisticaServidor_.servidor, servidor);
        } catch (Exception ex) {
            Logger.getLogger(EstatisticaServidorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
