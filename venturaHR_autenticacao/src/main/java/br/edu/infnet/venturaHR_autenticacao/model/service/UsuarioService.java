package br.edu.infnet.venturaHR_autenticacao.model.service;

import br.edu.infnet.venturaHR_autenticacao.model.domain.Usuario;
import br.edu.infnet.venturaHR_autenticacao.model.exception.LoginInvalido;
import br.edu.infnet.venturaHR_autenticacao.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario login(Usuario usuario){
        return usuarioRepository.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha())
                .orElseThrow(() -> new LoginInvalido("Usuário ou senha inválidos!"));
        }
    }
