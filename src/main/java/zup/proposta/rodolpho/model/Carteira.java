package zup.proposta.rodolpho.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
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
    @Enumerated(EnumType.STRING)
    private CarteiraAssociada carteiraAssociada;

    @Deprecated
    public Carteira() {}

    public Carteira(
            String id,
            String email,
            LocalDateTime associadaEm,
            String emissor,
            Cartao cartao,
            CarteiraAssociada carteiraAssociada
    ) {
        this.id = id;
        this.email = email;
        this.associadaEm = associadaEm;
        this.emissor = emissor;
        this.cartao = cartao;
        this.carteiraAssociada = carteiraAssociada;
    }

    public Carteira(String id, String email, Cartao cartao, String carteiraAssociada) {
        this(
                id, email, LocalDateTime.now(),
                null, cartao, CarteiraAssociada.valueOf(carteiraAssociada)
        );
    }

    public String getId() {
        return id;
    }
}
