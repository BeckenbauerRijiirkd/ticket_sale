package ticket.sale.ticket_sale.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ticket.sale.ticket_sale.controller.dto.EventoDto;
import ticket.sale.ticket_sale.controller.modelViewer.EventoModelViewer;
import ticket.sale.ticket_sale.model.Evento;
import ticket.sale.ticket_sale.repository.EventoRepository;

@RestController
@RequestMapping("/Eventos")
public class EventoController {
    
    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping
    public ResponseEntity<List<EventoDto>> listar(){
        
        List<Evento> eventos = eventoRepository.findAll();

        return ResponseEntity.ok(EventoDto.converter(eventos));
    
    }

    @PostMapping
    public void CriarEvento(@RequestBody EventoModelViewer eventoModelViewer){

        System.out.println(eventoModelViewer);
    }

}