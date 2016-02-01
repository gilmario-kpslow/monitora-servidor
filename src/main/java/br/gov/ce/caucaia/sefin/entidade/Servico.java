package br.gov.ce.caucaia.sefin.entidade;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author gilmario
 */
@Entity
public class Servico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(nullable = false)
    @ManyToOne(cascade = CascadeType.MERGE)
    private Servidor servidor;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Integer porta;
    private String contexto;
    @Enumerated(EnumType.STRING)
    private TipoServico tipoServico;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar ultimaResposta;
    @Enumerated(EnumType.STRING)
    private StatusServico statusServico;

    public String getContexto() {
        return contexto;
    }

    public void setContexto(String contexto) {
        this.contexto = contexto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPorta() {
        return porta;
    }

    public void setPorta(Integer porta) {
        this.porta = porta;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    public Calendar getUltimaResposta() {
        return ultimaResposta;
    }

    public void setUltimaResposta(Calendar ultimaResposta) {
        this.ultimaResposta = ultimaResposta;
    }

    public StatusServico getStatusServico() {
        return statusServico;
    }

    public void setStatusServico(StatusServico statusServico) {
        this.statusServico = statusServico;
    }

    public String getPath() {
        StringBuilder builder = new StringBuilder("http://");
        builder.append(servidor.getIp());
        if (porta != null) {
            builder.append(":");
            builder.append(porta);
        }
        builder.append("/");
        builder.append(contexto);
        return builder.toString();
    }

    public boolean testar() throws Exception {
        return getTipoServico().testar(this);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Servico other = (Servico) obj;
        return Objects.equals(this.id, other.id);
    }

}
