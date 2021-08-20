package zup.proposta.rodolpho.controller.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import zup.proposta.rodolpho.model.Cartao;
import zup.proposta.rodolpho.model.Parcela;

import java.math.BigDecimal;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ParcelaResponse {
    private String id;
    private Integer quantidade;
    private BigDecimal valor;

    public Parcela toModel(Cartao cartao) {
        return new Parcela(id, quantidade, valor, cartao);
    }
}
