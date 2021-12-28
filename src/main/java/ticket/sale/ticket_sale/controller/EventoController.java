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
import ticket.sale.ticket_sale.model.Evento;
import ticket.sale.ticket_sale.model.Responsavel;
import ticket.sale.ticket_sale.repository.EventoRepository;
import ticket.sale.ticket_sale.service.ResponsavelService;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    
    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    ResponsavelService responsavelService;

    @GetMapping
    public ResponseEntity<List<EventoDto>> listar(){
        
        List<Evento> eventos = eventoRepository.findAll();

        return ResponseEntity.ok(EventoDto.converter(eventos));
    
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> CriarEvento(@RequestBody @Valid EventoModelViewer eventoModelViewer){

        Responsavel responsavel = responsavelService.verificarResponsvel(eventoModelViewer.getResponsavelId());

        if(responsavel == null){
            return(ResponseEntity.badRequest().body("Responsavel não encontrado"));
        }

        Evento evento = eventoModelViewer.converter(responsavel);

        eventoRepository.save(evento);

        return(ResponseEntity.ok("Evento Criado Com Sucesso"));
    }

}