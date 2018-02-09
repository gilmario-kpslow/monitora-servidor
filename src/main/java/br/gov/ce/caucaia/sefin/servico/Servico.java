package br.gov.ce.caucaia.sefin.servico;

import br.gov.ce.caucaia.sefin.servidor.Servidor;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

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
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Servidor servidor;
    @Column(nullable = false, length = 60)
    @Length(min = 3, max = 60)
    @NotBlank
    private String nome;
    @Column(nullable = false)
    @Max(65550)
    private Integer porta;
    private String contexto;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    @NotNull
    private TipoServico tipoServico;
    private LocalDateTime ultimaResposta;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
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

    public LocalDateTime getUltimaResposta() {
        return ultimaResposta;
    }

    public void setUltimaResposta(LocalDateTime ultimaResposta) {
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
