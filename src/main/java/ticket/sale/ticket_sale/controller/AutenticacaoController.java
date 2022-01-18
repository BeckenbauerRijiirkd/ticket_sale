package ticket.sale.ticket_sale.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ticket.sale.ticket_sale.config.validation.security.TokenService;
import ticket.sale.ticket_sale.controller.dto.TokenDto;
import ticket.sale.ticket_sale.controller.modelViewer.LoginForm;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
// @Profile(value = {"prod", "test"})
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form) {

        UsernamePasswordAuthenticationToken dadosLogin = form.converter();
        try {

            Authentication authentication = authManager.authenticate(dadosLogin);

            String token = tokenService.gerarToken(authentication);

            return ResponseEntity.ok(new TokenDto(token, "Bearer"));

        } catch (AuthenticationException e) {

            return ResponseEntity.badRequest().build();

        }
    }
}