package ticket.sale.ticket_sale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ticket.sale.ticket_sale.controller.dto.EventoDto;
import ticket.sale.ticket_sale.controller.dto.ResponsavelDto;
import ticket.sale.ticket_sale.model.Responsavel;
import ticket.sale.ticket_sale.repository.ResponsavelRepository;

@RestController
@RequestMapping("/responsavel")
public class ResponsavelController {
    
    @Autowired
    private ResponsavelRepository responsavelRepository;
    
    @GetMapping
    public ResponseEntity<List<ResponsavelDto>> listar(){
        
        List<Responsavel> responsavel = responsavelRepository.findAll();

        return ResponseEntity.ok(ResponsavelDto.converter(responsavel));
    
    }
}
