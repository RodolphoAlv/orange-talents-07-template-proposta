package zup.proposta.rodolpho.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Vencimento {
    @Id
    private String id;
    private Integer dia;
    private LocalDateTime dataDeCriacao;
    @JsonIgnore
    @ManyToOne
    private Cartao cartao;

    @Deprecated
    public Vencimento() {}

    public Vencimento(String id, Integer dia, LocalDateTime dataDeCriacao, Cartao cartao) {
        this.id = id;
        this.dia = dia;
        this.dataDeCriacao = dataDeCriacao;
        this.cartao = cartao;
    }
}
