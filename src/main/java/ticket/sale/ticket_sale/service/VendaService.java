package ticket.sale.ticket_sale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ticket.sale.ticket_sale.controller.modelViewer.VendaModelViewer;
import ticket.sale.ticket_sale.model.Cliente;
import ticket.sale.ticket_sale.model.Evento;
import ticket.sale.ticket_sale.model.TipoIngresso;
import ticket.sale.ticket_sale.model.Venda;
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

    public List<Venda> buscarVendas(){

        return vendaRepository.findAll();
    }

    public Optional<Venda> buscarVenda(Long id){

        Optional<Venda> venda = vendaRepository.findById(id);

        return venda;
    }
    
    public void emitirVenda(Evento evento, Cliente cliente, VendaModelViewer vendaModelViewer){
    
        if(vendaModelViewer.getTipoIngresso() == TipoIngresso.INTEIRA){
            vendaModelViewer.setValorTotal(vendaModelViewer.getQtdIngresso() * evento.getValor());
        }else{
            vendaModelViewer.setValorTotal(vendaModelViewer.getQtdIngresso() * evento.getValorMeia());
        }
        
        Venda venda = new Venda(evento,cliente,
                                 vendaModelViewer.getTipoIngresso(),
                                  vendaModelViewer.getQtdIngresso(),
                                   vendaModelViewer.getValorTotal());
        vendaRepository.save(venda);
    }

}