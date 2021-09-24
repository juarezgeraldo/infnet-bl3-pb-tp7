package br.edu.infnet.venturaHR_autenticacao.model.repository;

import br.edu.infnet.venturaHR_autenticacao.model.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByEmailAndSenha(String email, String senha);
}
