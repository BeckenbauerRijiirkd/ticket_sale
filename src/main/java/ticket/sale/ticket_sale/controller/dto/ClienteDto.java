package ticket.sale.ticket_sale.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import ticket.sale.ticket_sale.model.Cliente;

public class ClienteDto {

    private Long id;
    private String nome;
    private String cpf;
    private int compras;

    public ClienteDto() {
    }

    public ClienteDto(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getCompras() {
        return compras;
    }

    public void setCompras(int compras) {
        this.compras = compras;
    }

    public static List<ClienteDto> converter(List<Cliente> cliente) {
        return (cliente.stream().map(ClienteDto::new).collect(Collectors.toList()));
    }

}
