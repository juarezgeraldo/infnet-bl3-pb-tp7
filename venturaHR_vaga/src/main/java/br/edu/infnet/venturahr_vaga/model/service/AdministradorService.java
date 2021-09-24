package br.edu.infnet.venturahr_vaga.model.service;

import br.edu.infnet.venturahr_vaga.model.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private AdministradorRepository administradorRepository;


}
