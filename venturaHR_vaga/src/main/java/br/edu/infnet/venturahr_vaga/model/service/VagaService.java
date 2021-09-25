package br.edu.infnet.venturahr_vaga.model.service;

import br.edu.infnet.venturahr_vaga.model.domain.CriteriosVaga;
import br.edu.infnet.venturahr_vaga.model.domain.Empresa;
import br.edu.infnet.venturahr_vaga.model.domain.Vaga;
import br.edu.infnet.venturahr_vaga.model.domain.enumerations.StatusVaga;
import br.edu.infnet.venturahr_vaga.model.exception.VagaNaoEncontradaException;
import br.edu.infnet.venturahr_vaga.model.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private CriteriosVagaService criteriosVagaService;

    @PersistenceContext
    private EntityManager entityManager;

    public Vaga incluir(Vaga vaga) {
        vaga.setDataInicio(LocalDateTime.now());
        vaga.setDataFinal(LocalDateTime.now());
        vaga.setStatusVaga(StatusVaga.ABERTA);
        vaga.setPmdCalculado(calculaPmd(vaga));
        Vaga vagaSalva = vagaRepository.save(vaga);
        for (CriteriosVaga criteriosVaga : vaga.getCriteriosVagaList()) {
            criteriosVaga.setVaga(vagaSalva);
        }
        criteriosVagaService.incluirCriterios(vaga.getCriteriosVagaList());
        return vagaSalva;
    }

    private float calculaPmd(Vaga vaga) {
        float somaPesos = 0;
        float numerador = 0;

        for (CriteriosVaga criteriosVaga : vaga.getCriteriosVagaList()) {
            somaPesos += criteriosVaga.getPeso();
            numerador += criteriosVaga.getPmd().getValor() * criteriosVaga.getPeso();
        }
        if (somaPesos == 0) {
            return 0.0F;
        } else {
            return (numerador / somaPesos);
        }
    }

    public Vaga findById(Long id) {
        return vagaRepository
                .findById(id)
                .orElseThrow(() -> new VagaNaoEncontradaException("Vaga com o id " + id + " não foi encontrada"));
    }


    public List<Vaga> listar(String titulo, Empresa usuarioEmpresa, String statusVaga) {

        VagaRepository vagaRepository = null;
//        Vaga v = new Vaga();
//        v.setTitulo(titulo);
//        v.setUsuarioEmpresa(usuarioEmpresa);
//        v.setStatusVaga(StatusVaga.valueOf(statusVaga));
//        Example<Vaga> example = Example.of(v);
//        return  vagaRepository.findAll(example);
        return (List<Vaga>) vagaRepository.findAll();
    }

    public List<Vaga> listarTudo() {
        return (List<Vaga>) vagaRepository.findAll();
    }

    public void salvarVagasList(List<Vaga> vagas) {
        vagaRepository.saveAll(vagas);
    }

    public void salvarVaga(Vaga vaga) {
        vagaRepository.save(vaga);
    }

}
