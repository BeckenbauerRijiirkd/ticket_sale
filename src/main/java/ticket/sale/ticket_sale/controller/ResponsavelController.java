package ticket.sale.ticket_sale.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ticket.sale.ticket_sale.controller.dto.ResponsavelDto;
import ticket.sale.ticket_sale.controller.modelViewer.ResponsavelModelViewer;
import ticket.sale.ticket_sale.model.Responsavel;
import ticket.sale.ticket_sale.repository.ResponsavelRepository;
import ticket.sale.ticket_sale.service.ResponsavelService;

@RestController
@RequestMapping("/responsaveis")
public class ResponsavelController {
    
    @Autowired
    private ResponsavelRepository responsavelRepository;

    @Autowired
    ResponsavelService responsavelService;
    
    @GetMapping
    public ResponseEntity<List<ResponsavelDto>> listar(){
        
        List<Responsavel> responsavel = responsavelRepository.findAll();

        return ResponseEntity.ok(ResponsavelDto.converter(responsavel));
    
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastraResponsavel(@RequestBody @Valid ResponsavelModelViewer responsavelModelViewer){
        
        return (responsavelService.cadastrarResponsavel(responsavelModelViewer) ? 
                ResponseEntity.ok("Responsavel Cadastrado Com Sucesso") :
                ResponseEntity.badRequest().body("Cpf Ja Cadastrado"));
    }
}