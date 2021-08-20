package zup.proposta.rodolpho.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Parcela {
    @Id
    private String id;
    private Integer quantidade;
    private BigDecimal valor;
    @ManyToOne
    private Cartao cartao;

    @Deprecated
    public Parcela() {}

    public Parcela(String id, Integer quantidade, BigDecimal valor, Cartao cartao) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
        this.cartao = cartao;
    }
}
