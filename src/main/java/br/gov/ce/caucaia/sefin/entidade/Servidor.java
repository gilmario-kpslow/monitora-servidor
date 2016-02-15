package br.gov.ce.caucaia.sefin.entidade;

import br.gov.ce.caucaia.sefin.servico.testadores.TestadorServidor;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.mail.MessagingException;
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
    @Column(nullable = false, length = 1048)
    private String descricao;
    @Column(nullable = false)
    private String funcionalidade;
    @Column(nullable = false)
    private String sistemaOperacional;
    @Column(nullable = false)
    private String HD;
    @Column(nullable = false)
    private String memoria;
    @Column(nullable = false)
    private String processador;
    @Column(nullable = false)
    private Integer qtdProcessador;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoServidor tipo;
    @Enumerated(EnumType.STRING)
    private StatusServidor status;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar ultimoTeste;

    public Servidor() {

    }

    public String getFuncionalidade() {
        return funcionalidade;
    }

    public void setFuncionalidade(String funcionalidade) {
        this.funcionalidade = funcionalidade;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public String getHD() {
        return HD;
    }

    public void setHD(String HD) {
        this.HD = HD;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public Integer getQtdProcessador() {
        return qtdProcessador;
    }

    public void setQtdProcessador(Integer qtdProcessador) {
        this.qtdProcessador = qtdProcessador;
    }

    public TipoServidor getTipo() {
        return tipo;
    }

    public void setTipo(TipoServidor tipo) {
        this.tipo = tipo;
    }

    public void testar() throws IOException, MessagingException, InterruptedException {
        new TestadorServidor().testar(this);
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
