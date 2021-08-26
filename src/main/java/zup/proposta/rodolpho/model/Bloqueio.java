package zup.proposta.rodolpho.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Bloqueio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime bloqueadoEm = LocalDateTime.now();
    private String sistemaResponsavel;
    private Boolean ativo;
    @JsonIgnore
    @ManyToOne
    private Cartao cartao;

    @Deprecated
    public Bloqueio() {}

    public Bloqueio(
            Long id,
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

    public Bloqueio(String sistemaResponsavel, Boolean ativo, Cartao cartao) {
        this(null, LocalDateTime.now(), sistemaResponsavel, ativo, cartao);
    }

    public String getSistemaResponsavel() {
        return sistemaResponsavel;
    }

    public Long getId() {
        return id;
    }
}
