package ticket.sale.ticket_sale.controller.modelViewer;


public class VendaModelViewer {

    private Long eventoId;

    private Long clienteId;

    private String tipoIngresso;

    private int qtdIngresso;

    private Double valorTotal;

    public VendaModelViewer() {
    }

    public VendaModelViewer(Long eventoId, Long clienteId, String tipoIngresso, int qtdIngresso,
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

    public String getTipoIngresso() {
        return tipoIngresso;
    }

    public void setTipoIngresso(String tipoIngresso) {
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
