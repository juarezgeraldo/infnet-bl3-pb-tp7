package br.edu.infnet.venturahr_vaga.model.service;

import br.edu.infnet.venturahr_vaga.model.domain.Usuario;
import br.edu.infnet.venturahr_vaga.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public void validarUsuario(Usuario usuario){
        String email = usuario.getEmail();
        }
    }
