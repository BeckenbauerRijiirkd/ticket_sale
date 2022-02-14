package ticket.sale.ticket_sale.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ticket.sale.ticket_sale.controller.dto.VendaDetalhesDto;
import ticket.sale.ticket_sale.controller.dto.VendaDto;
import ticket.sale.ticket_sale.controller.modelViewer.VendaModelViewer;
import ticket.sale.ticket_sale.model.Cliente;
import ticket.sale.ticket_sale.model.Evento;
import ticket.sale.ticket_sale.model.Status;
import ticket.sale.ticket_sale.model.Venda;
import ticket.sale.ticket_sale.service.ClienteService;
import ticket.sale.ticket_sale.service.EventoService;
import ticket.sale.ticket_sale.service.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private ClienteService clienteservice;

    @Autowired
    private EventoService eventoService;

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public ResponseEntity<List<VendaDto>> listar() {

        return ResponseEntity.ok(VendaDto.converter(vendaService.buscarVendas()));

    }

    @PostMapping
    public ResponseEntity<String> EmitirVenda(@RequestBody VendaModelViewer vendaModelViewer) {

        Cliente cliente = clienteservice.verificarCliente(vendaModelViewer.getClienteId());
        if (cliente == null) {
            return ResponseEntity.badRequest().body("Cliente não Encontrado");
        }

        Evento evento = eventoService.verificarEvento(vendaModelViewer.getEventoId());
        if (evento == null) {
            return ResponseEntity.badRequest().body("Evento não encontrado");
        }

        if (evento.getStatus() != Status.VENDAS_ABERTAS) {
            return ResponseEntity.badRequest().body("Evento fechado para vendas");
        }

        vendaService.emitirVenda(evento, cliente, vendaModelViewer);

        return ResponseEntity.ok("Venda Emitida Com Sucesso");
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaDetalhesDto> buscarEvento(@PathVariable Long id) {

        Optional<Venda> venda = vendaService.buscarVenda(id);

        if (venda.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new VendaDetalhesDto(venda.get()));
    }

}