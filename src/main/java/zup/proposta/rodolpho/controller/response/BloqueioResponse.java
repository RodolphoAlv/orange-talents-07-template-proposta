package zup.proposta.rodolpho.controller.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import zup.proposta.rodolpho.model.Bloqueio;
import zup.proposta.rodolpho.model.Cartao;

import java.time.LocalDateTime;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BloqueioResponse {
    private String id;
    private LocalDateTime bloqueadoEm;
    private String sistemaResponsavel;
    private Boolean ativo;

    public Bloqueio toModel(Cartao cartao) {
        return new Bloqueio(id, bloqueadoEm, sistemaResponsavel, ativo, cartao);
    }
}
