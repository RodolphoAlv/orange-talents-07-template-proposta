package zup.proposta.rodolpho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zup.proposta.rodolpho.model.Aviso;

public interface AvisoRepository extends JpaRepository<Aviso, Long> {
}
