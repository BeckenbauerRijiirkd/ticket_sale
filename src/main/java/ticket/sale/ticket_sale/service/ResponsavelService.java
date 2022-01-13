package ticket.sale.ticket_sale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ticket.sale.ticket_sale.controller.modelViewer.ResponsavelModelViewer;
import ticket.sale.ticket_sale.controller.modelViewer.ResponsavelUpdateModelViewer;
import ticket.sale.ticket_sale.model.Responsavel;
import ticket.sale.ticket_sale.repository.ResponsavelRepository;

@Service
public class ResponsavelService {

    @Autowired
    ResponsavelRepository responsavelRepository;

    public List<Responsavel> buscarResponsaveis() {

        return responsavelRepository.findAll();
    }

    public Optional<Responsavel> buscarReponsavel(Long id) {

        Optional<Responsavel> responsavel = responsavelRepository.findById(id);

        return responsavel;
    }

    public Boolean verificarCpf(String cpf) {

        Responsavel responsavel = responsavelRepository.findByCpf(cpf);

        return (responsavel == null);
    }

    public Responsavel verificarResponsvel(Long responsavelId) {

        Optional<Responsavel> responsavelAux = responsavelRepository.findById(responsavelId);

        return (responsavelAux.isPresent() ? responsavelAux.get() : null);
    }

    public Boolean cadastrarResponsavel(ResponsavelModelViewer responsavelModelViewer) {

        if (verificarCpf(responsavelModelViewer.getCpf()) == false) {
            return (false);
        }

        String passwordEnconde = new BCryptPasswordEncoder().encode(responsavelModelViewer.getSenha());

        responsavelModelViewer.setSenha(passwordEnconde);

        Responsavel responsavel = responsavelModelViewer.Converter();

        responsavelRepository.save(responsavel);

        return (true);
    }

    public Responsavel atualizar(Responsavel responsavel, ResponsavelUpdateModelViewer responsavelUpdateModelViewer) {

        responsavel.setNome(responsavelUpdateModelViewer.getNome());
        responsavel.setDataNasc(responsavelUpdateModelViewer.getDataNascimento());
        responsavel.setCidade(responsavelUpdateModelViewer.getCidade());
        responsavel.setUf(responsavelUpdateModelViewer.getUf());
        responsavel.setEndereco(responsavelUpdateModelViewer.getEndereco());

        return responsavel;
    }

    public void delete(Responsavel responsavel) {
        responsavel.getUsuario().setAtivo(false);
        responsavel.setActive(false);
    }
}
