package ticket.sale.ticket_sale.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ticket.sale.ticket_sale.controller.modelViewer.VendaModelViewer;
import ticket.sale.ticket_sale.model.Cliente;
import ticket.sale.ticket_sale.repository.ClienteRepository;
import ticket.sale.ticket_sale.repository.EventoRepository;
import ticket.sale.ticket_sale.repository.VendaRepository;

@Service
public class VendaService {
    
    @Autowired
    VendaRepository vendaRepository;

    @Autowired
    EventoRepository eventoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public void verificarVenda(VendaModelViewer vendaModelViewer){
        Optional<Cliente> cliente = clienteRepository.findById(vendaModelViewer.getClienteId());
        if(cliente == null){

        }
    }



}