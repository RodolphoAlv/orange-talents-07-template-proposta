package zup.proposta.rodolpho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zup.proposta.rodolpho.model.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, String> {
}
