package ticket.sale.ticket_sale.controller.modelViewer;

import static ticket.sale.ticket_sale.model.Status.VENDAS_ABERTAS;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import ticket.sale.ticket_sale.model.Evento;
import ticket.sale.ticket_sale.model.Responsavel;
import ticket.sale.ticket_sale.repository.ResponsavelRepository;

public class EventoModelViewer {
    @NotNull @NotEmpty
    private String nome;

    @NotNull
    private LocalDate data;

    @NotNull
    private Long responsavelId;

    @NotNull
    private Double valor;

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
    public Long getResponsavelId() {
        return responsavelId;
    }
    public void setResponsavelId(Long respontavelId) {
        this.responsavelId = respontavelId;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    public Responsavel VerificarResponsvel (ResponsavelRepository responsavelRepository){

        Optional<Responsavel>  responsavelAux = responsavelRepository.findById(responsavelId);
        
        if(responsavelAux.isPresent()){
        
            Responsavel responsavel = responsavelAux.get();
            
            return responsavel;
        }
            return null;
        }

    public Evento converter(ResponsavelRepository responsavelRepository) {
            
        Responsavel responsavel = VerificarResponsvel(responsavelRepository);
        
        if(responsavel != null){

            return new Evento(nome, data, responsavel, valor, (valor / 2), VENDAS_ABERTAS);
        }
            return null;
        }
    }