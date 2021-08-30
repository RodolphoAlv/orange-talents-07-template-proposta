package zup.proposta.rodolpho.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private String ipCliente;
    private String sistemaResponsavel;
    private LocalDateTime instante;

    @Deprecated
    public Aviso() {}

    public Aviso(LocalDate validoAte, String destino, Cartao cartao) {
        this.validoAte = validoAte;
        this.destino = destino;
        this.cartao = cartao;
    }

    public Aviso(
            LocalDate validoAte,
            String destino,
            Cartao cartao,
            String ipCliente,
            String sistemaResponsavel
    ) {
        this.validoAte = validoAte;
        this.destino = destino;
        this.cartao = cartao;
        this.ipCliente = ipCliente;
        this.sistemaResponsavel = sistemaResponsavel;
        this.instante = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }
}
