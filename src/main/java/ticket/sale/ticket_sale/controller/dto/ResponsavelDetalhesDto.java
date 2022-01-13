package ticket.sale.ticket_sale.controller.dto;

import java.time.LocalDate;

import ticket.sale.ticket_sale.model.Responsavel;

public class ResponsavelDetalhesDto {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String cidade;
    private String uf;
    private String endereco;
    private int eventos;

    public ResponsavelDetalhesDto() {
    }

    public ResponsavelDetalhesDto(Responsavel responsavel) {
        this.id = responsavel.getId();
        this.nome = responsavel.getNome();
        this.dataNascimento = responsavel.getDataNasc();
        this.cpf = responsavel.getCpf();
        this.cidade = responsavel.getCidade();
        this.uf = responsavel.getUf();
        this.endereco = responsavel.getEndereco();
        this.eventos = responsavel.getEvento().size();
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getEventos() {
        return eventos;
    }

    public void setEventos(int eventos) {
        this.eventos = eventos;
    }

}
