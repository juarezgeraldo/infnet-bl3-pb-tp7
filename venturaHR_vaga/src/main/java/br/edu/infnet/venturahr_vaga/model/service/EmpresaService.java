package br.edu.infnet.venturahr_vaga.model.service;

import br.edu.infnet.venturahr_vaga.model.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private EmpresaRepository empresaRepository;

}
