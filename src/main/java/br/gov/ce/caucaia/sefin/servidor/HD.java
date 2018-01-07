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
public class HD implements Serializable {

    @Column(precision = 5, scale = 2)
    private BigDecimal quantidadeHD;
    private UnidadeMemoria unidadeHD;

    public HD() {
    }

    public BigDecimal getQuantidadeHD() {
        return quantidadeHD;
    }

    public void setQuantidadeHD(BigDecimal quantidadeHD) {
        this.quantidadeHD = quantidadeHD;
    }

    public UnidadeMemoria getUnidadeHD() {
        return unidadeHD;
    }

    public void setUnidadeHD(UnidadeMemoria unidadeHD) {
        this.unidadeHD = unidadeHD;
    }

}
