package ticket.sale.ticket_sale.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ticket.sale.ticket_sale.controller.dto.ClienteDetalhesDto;
import ticket.sale.ticket_sale.controller.dto.ClienteDto;
import ticket.sale.ticket_sale.controller.modelViewer.ClienteModelViewer;
import ticket.sale.ticket_sale.controller.modelViewer.ClienteUpdateModelViewer;
import ticket.sale.ticket_sale.model.Cliente;
import ticket.sale.ticket_sale.service.ClienteService;
import ticket.sale.ticket_sale.service.UsuarioService;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<ClienteDto>> listarClientes() {

        return ResponseEntity.ok(ClienteDto.converter(clienteService.buscarClientes()));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrarCliente(@RequestBody @Valid ClienteModelViewer clienteModelViewer) {
//teste-deploy
        if (usuarioService.verificarEmail(clienteModelViewer.getEmail())) {
            return ResponseEntity.badRequest().body("Email Ja Cadastrado");
        }
        return (clienteService.cadastrarCliente(clienteModelViewer)
                ? ResponseEntity.status(HttpStatus.CREATED).build()
                : ResponseEntity.badRequest().body("Cpf Ja Cadastrado"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDetalhesDto> buscarCliente(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.buscarCliente(id);

        if (cliente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new ClienteDetalhesDto(cliente.get()));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ClienteDetalhesDto> atualizar(@PathVariable Long id,
            @RequestBody ClienteUpdateModelViewer clienteUpdateModelViewer) {

        Optional<Cliente> cliente = clienteService.buscarCliente(id);

        if (cliente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Cliente clienteAux = clienteService.atualizar(cliente.get(), clienteUpdateModelViewer);

        return ResponseEntity.ok(new ClienteDetalhesDto(clienteAux));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deletar(@PathVariable Long id) {

        Optional<Cliente> cliente = clienteService.buscarCliente(id);

        if (cliente.isPresent()) {

            clienteService.delete(cliente.get());

            return ResponseEntity.ok("Cliente excluido com sucesso");

        }
        return ResponseEntity.badRequest().body("Cliente não encontrado");
    }
}