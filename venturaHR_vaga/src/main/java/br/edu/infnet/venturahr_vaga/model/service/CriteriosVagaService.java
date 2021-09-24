package br.edu.infnet.venturahr_vaga.model.service;

import br.edu.infnet.venturahr_vaga.model.domain.CriteriosVaga;
import br.edu.infnet.venturahr_vaga.model.repository.CriteriosVagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriteriosVagaService {
    @Autowired
    private CriteriosVagaRepository criteriosVagaRepository;

    public void incluirCriterios(List<CriteriosVaga> criteriosVagaList) {
        criteriosVagaRepository.saveAll(criteriosVagaList);
    }

}
