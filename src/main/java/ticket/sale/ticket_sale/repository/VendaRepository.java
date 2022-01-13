package ticket.sale.ticket_sale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ticket.sale.ticket_sale.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

}