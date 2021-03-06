package ticket.sale.ticket_sale.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import ticket.sale.ticket_sale.model.Venda;

public class VendaDto {
    private Long id;
    private String evento;
    private String tipoDoIngresso;
    private int ingressos;
    private Double valorTotal;

    public VendaDto() {
    }

    public VendaDto(Venda venda) {
        this.id = venda.getId();
        this.evento = venda.getEvento().getNome();
        this.tipoDoIngresso = venda.getTipoIngresso().name();
        this.ingressos = venda.getQtdIngresso();
        this.valorTotal = venda.getValorTotal();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getTipoDoIngresso() {
        return tipoDoIngresso;
    }

    public void setTipoDoIngresso(String tipoDoIngresso) {
        this.tipoDoIngresso = tipoDoIngresso;
    }

    public int getIngressos() {
        return ingressos;
    }

    public void setIngressos(int ingressos) {
        this.ingressos = ingressos;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public static List<VendaDto> converter(List<Venda> vendas) {
        return (vendas.stream().map(VendaDto::new).collect(Collectors.toList()));
    }

}
