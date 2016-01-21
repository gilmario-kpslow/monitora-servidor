package br.gov.ce.caucaia.sefin.entidade;

import br.gov.ce.caucaia.sefin.servico.testadores.TestadorServidor;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author gilmario
 */
@Entity
public class Servidor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String ip;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String descricao;
    @Enumerated(EnumType.STRING)
    private StatusServidor status;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar ultimoTeste;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "servidor")
    private final List<Servico> listaDeServico;

    public Servidor() {
        listaDeServico = new ArrayList<>();
    }

    public List<Servico> getServicosAtivos() {
        List<Servico> ativos = new ArrayList<>();
        for (Servico next : listaDeServico) {
            if (StatusServico.Ativo.equals(next.getStatusServico())) {
                ativos.add(next);
            }
        }
        return ativos;
    }

    public void testar() throws IOException {
        new TestadorServidor().testar(this);
    }

    public List<Servico> getListaDeServico() {
        return Collections.unmodifiableList(listaDeServico);
    }

    public void addServico(Servico servico) {
        this.listaDeServico.add(servico);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getUltimoTeste() {
        return ultimoTeste;
    }

    public void setUltimoTeste(Calendar ultimoTeste) {
        this.ultimoTeste = ultimoTeste;
    }

    public StatusServidor getStatus() {
        return status;
    }

    public void setStatus(StatusServidor status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Servidor other = (Servidor) obj;
        return Objects.equals(this.id, other.id);
    }

}
