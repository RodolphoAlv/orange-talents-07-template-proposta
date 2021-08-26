package zup.proposta.rodolpho.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
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
    private String documento;
    @NotNull
    private String email;
    @NotNull
    private String nome;
    @NotNull
    @Positive
    private BigDecimal salario;
    @Enumerated(EnumType.STRING)
    private PropostaStatus status;
    @OneToOne(mappedBy = "proposta", cascade = CascadeType.PERSIST)
    private Cartao cartao;

    @Deprecated
    private Proposta() { }

    public Proposta(String documento, String email, String nome, BigDecimal salario) {
        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public void atualizaStatus(String resultadoSolicitacao) {

        SolicitacaoStatus solicitacaoStatus = SolicitacaoStatus
                .valueOf(resultadoSolicitacao);
        this.status = solicitacaoStatus.toCartaoStatus();
    }

    public void atualizaCartao(Cartao cartao) {
        this.cartao = cartao;
    }
}
