package br.edu.infnet.venturahr_vaga.model.repository;

import br.edu.infnet.venturahr_vaga.model.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    boolean existsByEmail(String email);
}
