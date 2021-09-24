package br.edu.infnet.venturaHR_usuarios.model.repository;

import br.edu.infnet.venturaHR_usuarios.model.domain.Administrador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorRepository extends CrudRepository<Administrador, Long> {
    boolean existsByCpf(String cpf);
    Optional<Administrador> findByCpf(String cpf);


}
