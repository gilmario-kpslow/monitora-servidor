package br.gov.ce.caucaia.sefin.servidor;

import br.gov.ce.caucaia.sefin.processador.Processador;
import br.gov.ce.caucaia.sefin.so.SistemaOperacional;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.mail.MessagingException;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author gilmario
 */
@Entity
public class Servidor implements Serializable {

    private static final String REGEX = "\\b(([01]?\\d?\\d|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d?\\d|2[0-4]\\d|25[0-5])\\b";

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
    @ManyToOne
    @JoinColumn(nullable = false)
    private SistemaOperacional sistemaOperacional;
    @Embedded
    private HD hd;
    @Embedded
    private Memoria memoria;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Processador processador;
    @Column(nullable = false)
    private Integer qtdProcessador;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoServidor tipo;
    @Enumerated(EnumType.STRING)
    private StatusServidor status;
    private LocalDate ultimoTeste;

    public Servidor() {
        status = StatusServidor.Inativo;
    }

    public String getFuncionalidade() {
        return funcionalidade;
    }

    public void setFuncionalidade(String funcionalidade) {
        this.funcionalidade = funcionalidade;
    }

    public SistemaOperacional getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(SistemaOperacional sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public HD getHd() {
        return hd;
    }

    public void setHd(HD hd) {
        this.hd = hd;
    }

    public Memoria getMemoria() {
        return memoria;
    }

    public void setMemoria(Memoria memoria) {
        this.memoria = memoria;
    }

    public Processador getProcessador() {
        return processador;
    }

    public void setProcessador(Processador processador) {
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

    public LocalDate getUltimoTeste() {
        return ultimoTeste;
    }

    public void setUltimoTeste(LocalDate ultimoTeste) {
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

    public void setIp(String ip) throws Exception {
        if (Objects.nonNull(ip) && !ip.matches(REGEX)) {
            throw new Exception("Endereço de IP Inválido");
        }
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
