package ticket.sale.ticket_sale.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ticket.sale.ticket_sale.model.Usuario;
import ticket.sale.ticket_sale.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    // public Boolean verificarEmail(String email) {

    //     Optional<Usuario> usuario = usuarioRepository.findByEmail(email);

    //     if(usuario.isEmpty()){
    //         return false;
    //     }

    //     return true;
    // }
}