package zup.proposta.rodolpho.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import zup.proposta.rodolpho.model.Proposta;

import java.util.Optional;

public interface PropostaRepository extends CrudRepository<Proposta, Long> {
    @Query("select 1 from Proposta p where p.cpfOuCnpj = :cpfOuCnpj")
    Optional<Proposta> findByDocumento(@Param("cpfOuCnpj") String cpfOuCnpj);
}
