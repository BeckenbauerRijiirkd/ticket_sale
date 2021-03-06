package ticket.sale.ticket_sale.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ticket.sale.ticket_sale.controller.dto.ResponsavelDetalhesDto;
import ticket.sale.ticket_sale.controller.dto.ResponsavelDto;
import ticket.sale.ticket_sale.controller.modelViewer.ResponsavelModelViewer;
import ticket.sale.ticket_sale.controller.modelViewer.ResponsavelUpdateModelViewer;
import ticket.sale.ticket_sale.model.Responsavel;
import ticket.sale.ticket_sale.service.ResponsavelService;
import ticket.sale.ticket_sale.service.UsuarioService;

@RestController
@RequestMapping("/responsaveis")
public class ResponsavelController {

    @Autowired
    ResponsavelService responsavelService;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<ResponsavelDto>> listar() {

        return ResponseEntity.ok(ResponsavelDto.converter(responsavelService.buscarResponsaveis()));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastraResponsavel(
            @RequestBody @Valid ResponsavelModelViewer responsavelModelViewer) {

        if(usuarioService.verificarEmail(responsavelModelViewer.getEmail())){
            return ResponseEntity.badRequest().body("Email Ja Cadastrado");
        }


        return (responsavelService.cadastrarResponsavel(responsavelModelViewer)
                ? ResponseEntity.ok("Responsavel Cadastrado Com Sucesso")
                : ResponseEntity.badRequest().body("Cpf Ja Cadastrado"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsavelDetalhesDto> buscarResponsavel(@PathVariable Long id) {

        Optional<Responsavel> responsavel = responsavelService.buscarReponsavel(id);

        if (responsavel.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new ResponsavelDetalhesDto(responsavel.get()));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ResponsavelDetalhesDto> atualizar(@PathVariable Long id,
            @RequestBody ResponsavelUpdateModelViewer responsavelUpdateModelViewer) {

        Optional<Responsavel> responsavel = responsavelService.buscarReponsavel(id);

        if (responsavel.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Responsavel responsavelAux = responsavelService.atualizar(responsavel.get(), responsavelUpdateModelViewer);

        return ResponseEntity.ok(new ResponsavelDetalhesDto(responsavelAux));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deletar(@PathVariable Long id) {

        Optional<Responsavel> responsavel = responsavelService.buscarReponsavel(id);

        if (responsavel.isPresent()) {

            responsavelService.delete(responsavel.get());

            return ResponseEntity.ok("Responsavel excluido com sucesso");

        }
        return ResponseEntity.badRequest().body("Responsavel n??o encontrado");
    }
}