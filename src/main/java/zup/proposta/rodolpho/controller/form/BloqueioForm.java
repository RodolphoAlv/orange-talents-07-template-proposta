package zup.proposta.rodolpho.controller.form;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import zup.proposta.rodolpho.model.Bloqueio;
import zup.proposta.rodolpho.model.Cartao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BloqueioForm {
    @NotBlank
    private String sistemaResponsavel;
    @NotNull
    private Boolean ativo;

    public Bloqueio toModel(Cartao cartao) {
        return new Bloqueio(sistemaResponsavel, ativo, cartao);
    }
}
