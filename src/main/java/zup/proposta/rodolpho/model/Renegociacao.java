package zup.proposta.rodolpho.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Renegociacao {
    @Id
    private String id;
    private Integer quantidade;
    private BigDecimal valor;
    private LocalDateTime dataDeCriacao;
    @JsonIgnore
    @ManyToOne
    private Cartao cartao;

    @Deprecated
    public Renegociacao() {}

    public Renegociacao(
            String id,
            Integer quantidade,
            BigDecimal valor,
            LocalDateTime dataDeCriacao,
            Cartao cartao
    ) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
        this.dataDeCriacao = dataDeCriacao;
        this.cartao = cartao;
    }
}
