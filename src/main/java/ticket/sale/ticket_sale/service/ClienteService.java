package ticket.sale.ticket_sale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ticket.sale.ticket_sale.controller.modelViewer.ClienteModelViewer;
import ticket.sale.ticket_sale.controller.modelViewer.ClienteUpdateModelViewer;
import ticket.sale.ticket_sale.model.Cliente;
import ticket.sale.ticket_sale.repository.ClienteRepository;
import ticket.sale.ticket_sale.repository.PerfilRepository;
import ticket.sale.ticket_sale.repository.UsuarioRepository;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    UsuarioRepository usuarioRepository;
    
    @Autowired
    PerfilRepository perfilRepository;


    public List<Cliente> buscarClientes(){

        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarCliente(Long id){

        Optional<Cliente> cliente = clienteRepository.findById(id);

        return cliente;
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

    public Cliente atualizar(Cliente cliente, ClienteUpdateModelViewer clienteUpdateModelViewer) {
        
        cliente.setNome(clienteUpdateModelViewer.getNome());
        cliente.setDataNasc(clienteUpdateModelViewer.getDataNascimento());
        cliente.setCidade(clienteUpdateModelViewer.getCidade());
        cliente.setUf(clienteUpdateModelViewer.getUf());

        return cliente;
    }

    public void delete(Cliente cliente){
        cliente.getUsuario().setAtivo(false);
        cliente.setAtivo(false);
    }
}