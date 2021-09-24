package br.edu.infnet.venturaHR_usuarios.model.repository;

import br.edu.infnet.venturaHR_usuarios.model.domain.Candidato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidatoRepository extends CrudRepository<Candidato, Long> {
    boolean existsByCpf(String cpf);
    Optional<Candidato>  findByCpf(String cpf);

}
