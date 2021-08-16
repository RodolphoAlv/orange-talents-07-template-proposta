package zup.proposta.rodolpho.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Proposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String cpfOuCnpj;
    @NotNull
    private String email;
    @NotNull
    private String nome;
    @NotNull
    @Positive
    private BigDecimal salario;

    @Deprecated
    private Proposta() { }

    public Proposta(String cpfOuCnpj, String email, String nome, BigDecimal salario) {
        this.cpfOuCnpj = cpfOuCnpj;
        this.email = email;
        this.nome = nome;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }
}
