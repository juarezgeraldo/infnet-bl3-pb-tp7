package br.edu.infnet.venturahr_vaga.model.repository;

import br.edu.infnet.venturahr_vaga.model.domain.Vaga;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaRepository extends CrudRepository<Vaga, Long> {

}
