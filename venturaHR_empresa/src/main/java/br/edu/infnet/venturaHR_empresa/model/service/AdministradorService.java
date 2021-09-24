package br.edu.infnet.venturaHR_empresa.model.service;

import br.edu.infnet.venturaHR_empresa.model.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private AdministradorRepository administradorRepository;


}
