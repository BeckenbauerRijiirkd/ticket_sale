package ticket.sale.ticket_sale.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Evento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private LocalDate data;
    
    private Responsavel responsavel;
    private Double valor;
    private Double valorMeia = (valor / 2);
    private Status status; 

}