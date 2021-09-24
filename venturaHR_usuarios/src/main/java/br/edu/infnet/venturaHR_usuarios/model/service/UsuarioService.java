package br.edu.infnet.venturaHR_usuarios.model.service;

import br.edu.infnet.venturaHR_usuarios.model.domain.Usuario;
import br.edu.infnet.venturaHR_usuarios.model.exception.UsuarioJaExiste;
import br.edu.infnet.venturaHR_usuarios.model.repository.UsuarioRepository;
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
        if (usuarioRepository.existsByEmail(email)){
            throw new UsuarioJaExiste("Já existe um usuário com o e-mail informado: " + email);
        }
    }

}
