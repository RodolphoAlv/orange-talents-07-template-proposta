package zup.proposta.rodolpho.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Aviso {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate validoAte;
    private String destino;
    @JsonIgnore
    @ManyToOne
    private Cartao cartao;

    @Deprecated
    public Aviso() {}

    public Aviso(LocalDate validoAte, String destino, Cartao cartao) {
        this.validoAte = validoAte;
        this.destino = destino;
        this.cartao = cartao;
    }
}
