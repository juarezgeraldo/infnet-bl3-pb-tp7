package br.edu.infnet.venturaHR_empresa.model.repository;

import br.edu.infnet.venturaHR_empresa.model.domain.CriteriosVaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriteriosVagaRepository extends CrudRepository<CriteriosVaga, Long> {
}
