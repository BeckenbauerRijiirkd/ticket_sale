package ticket.sale.ticket_sale.controller.modelViewer;

import ticket.sale.ticket_sale.model.TipoIngresso;

public class VendaModelViewer {

    private Long eventoId;

    private Long clienteId;

    private TipoIngresso tipoIngresso;

    private int qtdIngresso;

    private Double valorTotal;

    public VendaModelViewer() {
    }

    public VendaModelViewer(Long eventoId, Long clienteId, TipoIngresso tipoIngresso, int qtdIngresso,
            Double valorTotal) {
        this.eventoId = eventoId;
        this.clienteId = clienteId;
        this.tipoIngresso = tipoIngresso;
        this.qtdIngresso = qtdIngresso;
        this.valorTotal = valorTotal;
    }

    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public TipoIngresso getTipoIngresso() {
        return tipoIngresso;
    }

    public void setTipoIngresso(TipoIngresso tipoIngresso) {
        this.tipoIngresso = tipoIngresso;
    }

    public int getQtdIngresso() {
        return qtdIngresso;
    }

    public void setQtdIngresso(int qtdIngresso) {
        this.qtdIngresso = qtdIngresso;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
