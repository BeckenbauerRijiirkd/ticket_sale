package ticket.sale.ticket_sale.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ticket.sale.ticket_sale.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

}