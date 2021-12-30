package ticket.sale.ticket_sale.controller.dto;


import ticket.sale.ticket_sale.model.Venda;

public class VendaDetalhesDto {
    private Long id;
    private String evento;
    private String cliente;
    private String tipoDoIngresso;
    private int ingressos;
    private Double valorTotal;

    public VendaDetalhesDto() {
    }

    public VendaDetalhesDto(Venda venda) {
        this.id = venda.getId();
        this.evento = venda.getEvento().getNome();
        this.cliente = venda.getCliente().getNome();
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
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
    
}
