package br.edu.infnet.venturaHR_empresa.model.service;

import br.edu.infnet.venturaHR_empresa.model.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private EmpresaRepository empresaRepository;

}
