package ticket.sale.ticket_sale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ticket.sale.ticket_sale.controller.dto.VendaDto;
import ticket.sale.ticket_sale.controller.modelViewer.VendaModelViewer;
import ticket.sale.ticket_sale.model.Venda;
import ticket.sale.ticket_sale.repository.VendaRepository;

@RestController
@RequestMapping("/vendas")
public class VendaController {
    
    @Autowired
    private VendaRepository vendaRepository;
    
    @GetMapping
    public ResponseEntity<List<VendaDto>> listar(){
        
        List<Venda> vendas = vendaRepository.findAll();

        return ResponseEntity.ok(VendaDto.converter(vendas));
    
    }

    @PostMapping
    public void EmitirVenda(@RequestBody VendaModelViewer VendaModelViewer){

    }

}