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

import ticket.sale.ticket_sale.controller.dto.ClienteDto;
import ticket.sale.ticket_sale.controller.modelViewer.ClienteModelViewer;
import ticket.sale.ticket_sale.model.Cliente;
import ticket.sale.ticket_sale.repository.ClienteRepository;
import ticket.sale.ticket_sale.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

        
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;
        
    @GetMapping
    public ResponseEntity<List<ClienteDto>> listar(){
            
        List<Cliente> cliente = clienteRepository.findAll();
    
        return ResponseEntity.ok(ClienteDto.converter(cliente));
        
    }
    
    @PostMapping
    @Transactional
    public ResponseEntity<String> CriarEvento(@RequestBody @Valid ClienteModelViewer clienteModelViewer){

        if(clienteService.verificarCpf(clienteModelViewer.getCpf()) == false){
            return(ResponseEntity.badRequest().body("Cpf Ja cadastrado!"));
        }

        Cliente cliente = clienteModelViewer.Converter();

        clienteRepository.save(cliente);

        return(ResponseEntity.ok("Cliente Cadastrado Com Sucesso"));
    }


}