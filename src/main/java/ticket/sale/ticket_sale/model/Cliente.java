package ticket.sale.ticket_sale.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Where;

@Entity
@Where(clause = "ativo=1")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private LocalDate dataNasc;
    private String cpf;
    private String cidade;
    private String uf;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Usuario usuario = new Usuario();

    private boolean ativo = usuario.isAtivo();

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Venda> compra;

    public Cliente() {
    }

    public Cliente(String nome, LocalDate dataNasc, String cpf, String cidade, String uf) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.cidade = cidade;
        this.uf = uf;
    }

    public Cliente(String nome, LocalDate dataNasc, String cpf, String cidade, String uf, Usuario usuario) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.cidade = cidade;
        this.uf = uf;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<Venda> getCompra() {
        return compra;
    }

    public void setCompra(List<Venda> compra) {
        this.compra = compra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}