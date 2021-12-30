package ticket.sale.ticket_sale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ticket.sale.ticket_sale.controller.modelViewer.ClienteModelViewer;
import ticket.sale.ticket_sale.model.Cliente;
import ticket.sale.ticket_sale.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> buscarClientes(){

        return clienteRepository.findAll();
    }

    public Cliente verificarCliente(Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente == null){
            return null;
        }
        return cliente.get();
    }

    public Boolean verificarCpf(String cpf) {
            
        Cliente cliente = clienteRepository.findByCpf(cpf);

        return (cliente == null);
    }

    public boolean cadastrarCliente(ClienteModelViewer clienteModelViewer){

        if(verificarCpf(clienteModelViewer.getCpf()) == false){
            return(false);
        }

        Cliente cliente = clienteModelViewer.Converter();

        clienteRepository.save(cliente);

        return (true);
    }
}