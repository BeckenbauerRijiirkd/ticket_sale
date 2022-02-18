package ticket.sale.ticket_sale.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import ticket.sale.ticket_sale.model.Evento;

public class EventoDto {

    private Long id;
    private String nome;
    private LocalDate data;

    private String responsavel;
    private Double valor;
    private Double valorMeia;

    private String status;

    private int vendas;

    private String url = "https://ticketsale.vercel.app/assets/img/Trance-Music.jpg";

    public EventoDto() {
    }

    public EventoDto(Evento evento) {
        this.id = evento.getId();
        this.nome = evento.getNome();
        this.data = evento.getData();
        this.responsavel = evento.getResponsavel().getNome();
        this.valor = evento.getValor();
        this.valorMeia = evento.getValorMeia();
        this.status = evento.getStatus().toString();
        this.vendas = evento.getVenda().size();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getValorMeia() {
        return valorMeia;
    }

    public void setValorMeia(Double valorMeia) {
        this.valorMeia = valorMeia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getVenda() {
        return vendas;
    }

    public void setVenda(int venda) {
        this.vendas = venda;
    }

    public static List<EventoDto> converter(List<Evento> evento) {
        return (evento.stream().map(EventoDto::new).collect(Collectors.toList()));
    }

}