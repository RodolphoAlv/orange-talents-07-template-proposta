package zup.proposta.rodolpho.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Cartao {
    @Id
    private String id;
    private LocalDateTime emitidoEm;
    private String titular;
    @OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
    private List<Bloqueio> bloqueios;
    @OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
    private List<Aviso> avisos;
    @OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
    private List<Carteira> carteiras;
    @OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
    private List<Parcela> parcelas;
    private BigDecimal limite;
    @OneToOne(mappedBy = "cartao", cascade = CascadeType.MERGE)
    private Renegociacao renegociacao;
    @OneToOne(mappedBy = "cartao", cascade = CascadeType.MERGE)
    private Vencimento vencimento;
    @OneToOne
    @JsonIgnore
    private Proposta proposta;
    @Enumerated(EnumType.STRING)
    private CartaoStatus status;

    @Deprecated
    public Cartao() {}

    public Cartao(
            String id,
            LocalDateTime emitidoEm,
            String titular,
            List<Bloqueio> bloqueios,
            List<Aviso> avisos,
            List<Carteira> carteiras,
            List<Parcela> parcelas,
            BigDecimal limite,
            Renegociacao renegociacao,
            Vencimento vencimento,
            Proposta proposta
    ) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.bloqueios = bloqueios;
        this.avisos = avisos;
        this.carteiras = carteiras;
        this.parcelas = parcelas;
        this.limite = limite;
        this.renegociacao = renegociacao;
        this.vencimento = vencimento;
        this.proposta = proposta;
        this.status = CartaoStatus.DESBLOQUEADO;
    }

    public Cartao(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setCartaoStatus(CartaoStatus resultado) {
        this.status = resultado;
    }
}
