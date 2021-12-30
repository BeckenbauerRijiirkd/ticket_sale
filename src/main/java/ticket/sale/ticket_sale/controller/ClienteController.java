package ticket.sale.ticket_sale.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ticket.sale.ticket_sale.controller.dto.ClienteDetalhesDto;
import ticket.sale.ticket_sale.controller.dto.ClienteDto;
import ticket.sale.ticket_sale.controller.modelViewer.ClienteModelViewer;
import ticket.sale.ticket_sale.model.Cliente;
import ticket.sale.ticket_sale.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
        
    @GetMapping
    public ResponseEntity<List<ClienteDto>> listarClientes(){
            
        return ResponseEntity.ok(ClienteDto.converter(clienteService.buscarClientes()));
    }
    
    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrarCliente(@RequestBody @Valid ClienteModelViewer clienteModelViewer){

        return (clienteService.cadastrarCliente(clienteModelViewer) ? 
        ResponseEntity.ok("Cliente Cadastrado Com Sucesso") :
        ResponseEntity.badRequest().body("Cpf Ja Cadastrado"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDetalhesDto> buscarCliente(@PathVariable Long id){
        
        Optional<Cliente> cliente = clienteService.buscarCliente(id);

        if (cliente.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok( new ClienteDetalhesDto(cliente.get()));
    }
}