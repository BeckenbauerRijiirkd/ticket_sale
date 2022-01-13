package ticket.sale.ticket_sale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ticket.sale.ticket_sale.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}