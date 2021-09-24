package br.edu.infnet.venturaHR_empresa.model.service;

import br.edu.infnet.venturaHR_empresa.model.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatoService {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private CandidatoRepository candidatoRepository;


}
