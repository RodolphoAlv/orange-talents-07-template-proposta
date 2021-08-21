package zup.proposta.rodolpho.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import zup.proposta.rodolpho.model.Proposta;

import java.util.List;
import java.util.Optional;

public interface PropostaRepository extends CrudRepository<Proposta, Long> {
    @Query("select 1 from Proposta p where p.documento = :documento")
    Optional<Proposta> findByDocumento(@Param("documento") String documento);

    @Query(value = "select * from proposta where proposta.id" +
            " not in (select cartao.proposta_id from cartao)" +
            " order by proposta.id asc limit 20", nativeQuery = true)
    List<Proposta> findAllPropostaCartaoNullStatusElegivel();
}
