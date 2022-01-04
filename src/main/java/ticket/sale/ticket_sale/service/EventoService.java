package ticket.sale.ticket_sale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ticket.sale.ticket_sale.controller.modelViewer.EventoModelViewer;
import ticket.sale.ticket_sale.controller.modelViewer.EventoUpdateModelViewer;
import ticket.sale.ticket_sale.model.Evento;
import ticket.sale.ticket_sale.model.Responsavel;
import ticket.sale.ticket_sale.repository.EventoRepository;

@Service
public class EventoService {
    
    @Autowired
    EventoRepository eventoRepository;

    @Autowired
    ResponsavelService responsavelService;

    public List<Evento> buscarEventos(){

        return eventoRepository.findAll();
    }

    public Optional<Evento> buscarEvento(Long id){

        Optional<Evento> evento = eventoRepository.findById(id);

        return evento;
    }

    public Evento verificarEvento(Long id){
        Optional<Evento> evento = eventoRepository.findById(id);
        if(evento == null){
            return null;
        }
        return evento.get();
    }

    public Boolean cadastrarEvento(EventoModelViewer eventoModelViewer){
        
        Responsavel responsavel = responsavelService.verificarResponsvel(eventoModelViewer.getResponsavelId());

        if(responsavel == null){
            return(false);
        }

        Evento evento = eventoModelViewer.converter(responsavel);

        eventoRepository.save(evento);

        return (true);
    }

    public Evento atualizar(Evento evento, EventoUpdateModelViewer eventoUpdateModelViewer){
        evento.setStatus(eventoUpdateModelViewer.getStatus());
        
        return evento;
    }
}

