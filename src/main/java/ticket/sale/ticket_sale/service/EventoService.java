package ticket.sale.ticket_sale.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ticket.sale.ticket_sale.model.Evento;
import ticket.sale.ticket_sale.repository.EventoRepository;

@Service
public class EventoService {
    
    @Autowired
    EventoRepository eventoRepository;

    public Evento verificarEvento(Long id){
        Optional<Evento> evento = eventoRepository.findById(id);
        if(evento == null){
            return null;
        }
        return evento.get();
    }
}