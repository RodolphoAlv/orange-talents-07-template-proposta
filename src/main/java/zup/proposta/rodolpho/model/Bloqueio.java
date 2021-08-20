package zup.proposta.rodolpho.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Bloqueio {
    @Id
    private String id;
    private LocalDateTime bloqueadoEm;
    private String sistemaResponsavel;
    private Boolean ativo;
    @ManyToOne
    private Cartao cartao;

    @Deprecated
    public Bloqueio() {}

    public Bloqueio(
            String id,
            LocalDateTime bloqueadoEm,
            String sistemaResponsavel,
            Boolean ativo,
            Cartao cartao
    ) {
        this.id = id;
        this.bloqueadoEm = bloqueadoEm;
        this.sistemaResponsavel = sistemaResponsavel;
        this.ativo = ativo;
        this.cartao = cartao;
    }
}
