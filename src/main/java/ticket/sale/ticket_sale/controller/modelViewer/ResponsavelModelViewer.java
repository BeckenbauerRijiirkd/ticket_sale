package ticket.sale.ticket_sale.controller.modelViewer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ticket.sale.ticket_sale.model.Perfil;
import ticket.sale.ticket_sale.model.Responsavel;
import ticket.sale.ticket_sale.model.Usuario;

public class ResponsavelModelViewer {

    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String cidade;
    private String uf;
    private String endereco;
    private String email;
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Responsavel Converter() {
        Perfil perfil = new Perfil("ROLE_RESPONSAVEL");

        List<Perfil> perfis = new ArrayList<>();
        perfis.add(perfil);

        Usuario usuario = new Usuario(email, senha, perfis);

        return new Responsavel(nome, dataNascimento, cpf, cidade, uf, endereco, usuario);
    }

}