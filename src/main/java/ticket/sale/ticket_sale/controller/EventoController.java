package ticket.sale.ticket_sale.controller;


import java.util.List;

import javax.validation.Valid;

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
import ticket.sale.ticket_sale.service.EventoService;
import ticket.sale.ticket_sale.service.ResponsavelService;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    
    @Autowired
    ResponsavelService responsavelService;

    @Autowired
    EventoService eventoService;

    @GetMapping
    public ResponseEntity<List<EventoDto>> listar(){

        return ResponseEntity.ok(EventoDto.converter(eventoService.buscarEventos()));    
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> CriarEvento(@RequestBody @Valid EventoModelViewer eventoModelViewer){

        return (eventoService.cadastrarEvento(eventoModelViewer) ? 
                ResponseEntity.ok("Evento Cadastrado Com Sucesso") :
                ResponseEntity.badRequest().body("Responsavel nâo encontrado"));
    }
}