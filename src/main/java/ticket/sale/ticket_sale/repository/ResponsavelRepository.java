package ticket.sale.ticket_sale.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ticket.sale.ticket_sale.model.Responsavel;

public interface ResponsavelRepository extends JpaRepository<Responsavel, Long>{

    Responsavel findByCpf(String cpf);
    Optional<Responsavel> findById(Long id);
}