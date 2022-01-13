package ticket.sale.ticket_sale.controller.modelViewer;

import java.time.LocalDate;

import ticket.sale.ticket_sale.model.Responsavel;

public class ResponsavelModelViewer {

    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String cidade;
    private String uf;
    private String endereco;

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

    public Responsavel Converter() {

        return new Responsavel(nome, dataNascimento, cpf, cidade, uf, endereco);
    }

}