package zup.proposta.rodolpho.controller.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import zup.proposta.rodolpho.model.Cartao;
import zup.proposta.rodolpho.model.Vencimento;

import java.time.LocalDateTime;
import java.util.Objects;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class VencimentoResponse {
    private String id;
    private Integer dia;
    private LocalDateTime dataDeCriacao;

    public Vencimento toModel(Cartao cartao) {
        if(Objects.nonNull(id)) {
            return new Vencimento(id, dia, dataDeCriacao, cartao);
        }

        return null;
    }
}
