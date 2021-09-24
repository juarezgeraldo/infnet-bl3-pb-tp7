package br.edu.infnet.venturahr_vaga.model.repository;

import br.edu.infnet.venturahr_vaga.model.domain.Administrador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorRepository extends CrudRepository<Administrador, Long> {
    boolean existsByCpf(String cpf);
    Optional<Administrador> findByCpf(String cpf);


}
