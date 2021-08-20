package zup.proposta.rodolpho.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Carteira {
    @Id
    private String id;
    private String email;
    private LocalDateTime associadaEm;
    private String emissor;
    @JsonIgnore
    @ManyToOne
    private Cartao cartao;

    @Deprecated
    public Carteira() {}

    public Carteira(
            String id,
            String email,
            LocalDateTime associadaEm,
            String emissor,
            Cartao cartao
    ) {
        this.id = id;
        this.email = email;
        this.associadaEm = associadaEm;
        this.emissor = emissor;
        this.cartao = cartao;
    }
}
