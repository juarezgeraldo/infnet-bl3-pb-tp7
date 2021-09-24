package br.edu.infnet.venturaHR_usuarios.model.repository;

import br.edu.infnet.venturaHR_usuarios.model.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    boolean existsByEmail(String email);
}
