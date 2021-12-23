package ticket.sale.ticket_sale.controller.modelViewer;

import java.time.LocalDate;
import java.util.Optional;

import ticket.sale.ticket_sale.model.Evento;
import ticket.sale.ticket_sale.model.Responsavel;
import ticket.sale.ticket_sale.model.Status;
import ticket.sale.ticket_sale.repository.ResponsavelRepository;

public class EventoModelViewer {
    
    private String nome;
    private LocalDate data;
    private Long respontavelId;
    private Double valor;
    private Status status;

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
    public Long getRespontavelId() {
        return respontavelId;
    }
    public void setRespontavelId(Long respontavelId) {
        this.respontavelId = respontavelId;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    
    public Evento converter(ResponsavelRepository responsavelRepository) {
            
        Optional<Responsavel>  responsavelAux = responsavelRepository.findById(respontavelId);
        
        if(responsavelAux.isPresent()){
        
            Responsavel responsavel = responsavelAux.get();

            return new Evento(nome, data, responsavel, valor, (valor / 2), status.VENDAS_ABERTAS);
        }
            return null;
        }
    }