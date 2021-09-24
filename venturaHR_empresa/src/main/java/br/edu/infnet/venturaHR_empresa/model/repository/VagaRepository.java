package br.edu.infnet.venturaHR_empresa.model.repository;

import br.edu.infnet.venturaHR_empresa.model.domain.Vaga;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaRepository extends CrudRepository<Vaga, Long> {

}
