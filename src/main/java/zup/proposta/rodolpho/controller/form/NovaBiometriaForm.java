package zup.proposta.rodolpho.controller.form;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import zup.proposta.rodolpho.model.Biometria;
import zup.proposta.rodolpho.model.Cartao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class NovaBiometriaForm {
    @NotBlank
    @Pattern(
            regexp = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$",
            message = "O formato da biometria não está em Base64!"
    )
    private String biometria;

    public Biometria toModel(Cartao cartao) {
        return new Biometria(biometria, cartao);
    }
}
