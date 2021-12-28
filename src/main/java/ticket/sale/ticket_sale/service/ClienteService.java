package ticket.sale.ticket_sale.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ticket.sale.ticket_sale.model.Cliente;
import ticket.sale.ticket_sale.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;

    public Cliente verificarCliente(Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente == null){
            return null;
        }
        return cliente.get();
    }

    public Boolean verificarCpf(String cpf) {
            
        Cliente cliente = clienteRepository.findByCpf(cpf);
        
        if(cliente != null){

            return false;

        }
            return true;
        }
}