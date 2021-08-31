package zup.proposta.rodolpho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zup.proposta.rodolpho.model.Carteira;

public interface CarteiraRepository extends JpaRepository<Carteira, String> {
}
