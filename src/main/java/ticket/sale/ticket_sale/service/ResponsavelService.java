package ticket.sale.ticket_sale.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ticket.sale.ticket_sale.controller.modelViewer.ResponsavelModelViewer;
import ticket.sale.ticket_sale.model.Responsavel;
import ticket.sale.ticket_sale.repository.ResponsavelRepository;

@Service
public class ResponsavelService {
    
@Autowired
ResponsavelRepository responsavelRepository;


    public Boolean verificarCpf(String cpf) {
            
        Responsavel responsavel = responsavelRepository.findByCpf(cpf);
        
        return (responsavel != null) ? false : true;
    }

    public Responsavel verificarResponsvel(Long responsavelId){

        Optional<Responsavel>  responsavelAux = responsavelRepository.findById(responsavelId);

        return (responsavelAux.isPresent() ? responsavelAux.get() : null);
    }

    public Boolean cadastrarResponsavel(ResponsavelModelViewer responsavelModelViewer){

        if(verificarCpf(responsavelModelViewer.getCpf()) == false){
            return(false);
        }

        Responsavel responsavel = responsavelModelViewer.Converter();

        responsavelRepository.save(responsavel);

        return (true);
    }
}
