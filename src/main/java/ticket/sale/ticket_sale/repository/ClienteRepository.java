package ticket.sale.ticket_sale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ticket.sale.ticket_sale.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
