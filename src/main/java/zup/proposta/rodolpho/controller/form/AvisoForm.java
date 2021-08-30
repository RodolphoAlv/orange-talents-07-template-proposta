package zup.proposta.rodolpho.controller.form;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import zup.proposta.rodolpho.model.Aviso;
import zup.proposta.rodolpho.model.Cartao;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AvisoForm {
    @NotBlank
    private String destino;
    @NotNull
    @Future
    private LocalDate validoAte;

    public Aviso toModel(Cartao cartao, String sistemaResponsavel, String ipCliente) {
        return new Aviso(validoAte, destino, cartao, ipCliente, sistemaResponsavel);
    }
}
