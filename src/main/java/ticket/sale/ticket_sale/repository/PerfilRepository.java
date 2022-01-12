package ticket.sale.ticket_sale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ticket.sale.ticket_sale.model.Perfil;



public interface PerfilRepository extends JpaRepository<Perfil, Long>{
    
}