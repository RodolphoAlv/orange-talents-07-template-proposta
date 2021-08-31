package zup.proposta.rodolpho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import zup.proposta.rodolpho.model.Cartao;

import java.util.Optional;

public interface CartaoRepository extends JpaRepository<Cartao, String> {

    @Query(
            value = "select * from cartao c where c.id = :cartaoId and " +
                    "c.id not in (select ct.cartao_id from carteira ct " +
                    "where ct.carteira_associada = :carteira)",
            nativeQuery = true
    )
    public Optional<Cartao> cartaoSemCarteiraAssociada(
            @Param("cartaoId") String cartaoId,
            @Param("carteira") String carteiraAssociada
    );
}
