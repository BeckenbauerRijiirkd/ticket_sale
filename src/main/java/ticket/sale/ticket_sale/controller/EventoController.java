package ticket.sale.ticket_sale.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ticket.sale.ticket_sale.controller.dto.EventoDetalhesDto;
import ticket.sale.ticket_sale.controller.dto.EventoDto;
import ticket.sale.ticket_sale.controller.modelViewer.EventoModelViewer;
import ticket.sale.ticket_sale.controller.modelViewer.EventoUpdateModelViewer;
import ticket.sale.ticket_sale.model.Evento;
import ticket.sale.ticket_sale.repository.EventoRepository;
import ticket.sale.ticket_sale.service.EventoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    EventoService eventoService;

    @GetMapping
    public Page<EventoDto> listar(@RequestParam(required = false) String nomeCurso,
    @PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10)
     Pageable paginacao){

        Page<Evento> eventos = eventoService.buscarEventos(paginacao);

        return EventoDto.converter(eventos);  

    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> CriarEvento(@RequestBody @Valid EventoModelViewer eventoModelViewer) {

        return (eventoService.cadastrarEvento(eventoModelViewer) ? ResponseEntity.ok("Evento Cadastrado Com Sucesso")
                : ResponseEntity.badRequest().body("Responsavel nâo encontrado"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoDetalhesDto> buscarEvento(@PathVariable Long id) {

        Optional<Evento> evento = eventoService.buscarEvento(id);

        if (evento.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new EventoDetalhesDto(evento.get()));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EventoDetalhesDto> atualizar(@PathVariable Long id,
            @RequestBody EventoUpdateModelViewer eventoUpdateUpdateModelViewer) {

        Optional<Evento> evento = eventoService.buscarEvento(id);

        if (evento.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Evento eventoAux = eventoService.atualizar(evento.get(), eventoUpdateUpdateModelViewer);

        return ResponseEntity.ok(new EventoDetalhesDto(eventoAux));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deletar(@PathVariable Long id) {

        Optional<Evento> evento = eventoService.buscarEvento(id);

        if (evento.isPresent()) {

            eventoService.delete(evento.get());

            return ResponseEntity.ok("Evento excluido com sucesso");

        }
        return ResponseEntity.badRequest().body("Evento não encontrado");
    }
}