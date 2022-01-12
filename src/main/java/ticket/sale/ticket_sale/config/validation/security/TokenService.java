package ticket.sale.ticket_sale.config.validation.security;



import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import ticket.sale.ticket_sale.model.Usuario;

@Service
public class TokenService {

    @Value("${forum.jwt.expiration}")
    private String expiration;
    
//    @Value("${forum.jwt.security}")
    private static String security = "sdfgsfdgertrscvbndhgfjhgfjfghjfghj";
    

    public String gerarToken(Authentication authentication) {
        
        Usuario logado = (Usuario) authentication.getPrincipal();
        Date hoje = new Date();
        Date dataExpiração = new Date(hoje.getTime() + Long.parseLong(expiration));
        
        return Jwts.builder()
        .setIssuer("API Ticket Sale")
        .setSubject(logado.getId().toString())
        .claim("email", logado.getEmail())
        .setIssuedAt(hoje)
        .setExpiration(dataExpiração)
        .signWith(SignatureAlgorithm.HS256, security)
        .compact();
    }


    public static boolean isTokenValido(String token) {
        try {
            
            Jwts.parser().setSigningKey(security).parseClaimsJws(token);

            return true;
        } catch (Exception e) {

            return false;
    }
}


    public Long getIdUsuario(String token) {

        Claims claims = Jwts.parser().setSigningKey(security).parseClaimsJws(token).getBody();

        return Long.parseLong(claims.getSubject());
    }
    
}