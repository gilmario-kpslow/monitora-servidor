package br.gov.ce.caucaia.sefin.servidor;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author gilmario
 */
@Embeddable
public class Memoria implements Serializable {

    @Column(precision = 5, scale = 2)
    private BigDecimal quantidadeMemoria;
    private UnidadeMemoria unidadeMemoria;

    public Memoria() {
    }

    public BigDecimal getQuantidadeMemoria() {
        return quantidadeMemoria;
    }

    public void setQuantidadeMemoria(BigDecimal quantidadeMemoria) {
        this.quantidadeMemoria = quantidadeMemoria;
    }

    public UnidadeMemoria getUnidadeMemoria() {
        return unidadeMemoria;
    }

    public void setUnidadeMemoria(UnidadeMemoria unidadeMemoria) {
        this.unidadeMemoria = unidadeMemoria;
    }

}
