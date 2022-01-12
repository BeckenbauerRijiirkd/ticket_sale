package ticket.sale.ticket_sale.controller.modelViewer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import ticket.sale.ticket_sale.model.Cliente;
import ticket.sale.ticket_sale.model.Perfil;
import ticket.sale.ticket_sale.model.Usuario;

public class ClienteModelViewer {

    @NotNull @NotEmpty
    private String nome;

    @NotNull
    private LocalDate dataNascimento;

    @NotNull @NotEmpty
    private String cpf;

    @NotNull @NotEmpty
    private String cidade;

    @NotNull @NotEmpty @Length(min = 2)
    private String uf;

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
    public Cliente Converter(){

        String passwordEncoder = new BCryptPasswordEncoder().encode(senha);

        senha = new BCryptPasswordEncoder().encode(senha);

        Perfil perfil = new Perfil("ROLE_CLIENTE");

        List<Perfil> perfis = new ArrayList<>(); 
        perfis.add(perfil);

        Usuario usuario = new Usuario(email, senha, perfis);

        return new Cliente(nome, dataNascimento, cpf, cidade, uf, usuario);  
    }

}
