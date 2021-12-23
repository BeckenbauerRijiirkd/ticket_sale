package ticket.sale.ticket_sale.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ticket.sale.ticket_sale.controller.dto.EventoDto;
import ticket.sale.ticket_sale.controller.modelViewer.EventoModelViewer;
import ticket.sale.ticket_sale.model.Evento;
import ticket.sale.ticket_sale.repository.EventoRepository;
import ticket.sale.ticket_sale.repository.ResponsavelRepository;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    
    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private ResponsavelRepository responsavelRepository;

    @GetMapping
    public ResponseEntity<List<EventoDto>> listar(){
        
        List<Evento> eventos = eventoRepository.findAll();

        return ResponseEntity.ok(EventoDto.converter(eventos));
    
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> CriarEvento(@RequestBody EventoModelViewer eventoModelViewer){

        Evento evento = eventoModelViewer.converter(responsavelRepository);

        if(evento == null){
            return(ResponseEntity.badRequest().body("Responsavel não encontrado"));
        }

        eventoRepository.save(evento);

        return(ResponseEntity.ok("Evento Criado Com Sucesso"));
    }

}