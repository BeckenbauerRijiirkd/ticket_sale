package ticket.sale.ticket_sale.controller.dto;

import java.time.LocalDate;

import ticket.sale.ticket_sale.model.Cliente;

public class ClienteDetalhesDto {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String cidade;
    private String uf;
    private int compras;

    public ClienteDetalhesDto() {
    }

    public ClienteDetalhesDto(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.dataNascimento = cliente.getDataNasc();
        this.cpf = cliente.getCpf();
        this.cidade = cliente.getCidade();
        this.uf = cliente.getUf();
        this.compras = cliente.getCompra().size();
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

    public int getCompras() {
        return compras;
    }

    public void setCompras(int compras) {
        this.compras = compras;
    }

}