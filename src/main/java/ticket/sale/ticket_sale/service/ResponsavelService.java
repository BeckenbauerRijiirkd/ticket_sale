package ticket.sale.ticket_sale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ticket.sale.ticket_sale.model.Responsavel;
import ticket.sale.ticket_sale.repository.ResponsavelRepository;

@Service
public class ResponsavelService {
    
@Autowired
ResponsavelRepository responsavelRepository;


    public Boolean verificarCpf(String cpf) {
            
        Responsavel responsavel = responsavelRepository.findByCpf(cpf);
        
        if(responsavel != null){

            return false;

        }
            return true;
    }
}