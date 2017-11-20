package br.gov.ce.caucaia.sefin.configuracao;

import br.gov.ce.caucaia.sefin.configuracao.Configuracao;
import br.gov.ce.caucaia.sefin.dao.DAO;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
public class ConfiguracaoDAO extends DAO<Configuracao, Long> implements Serializable {

}
