package zup.proposta.rodolpho.controller.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import zup.proposta.rodolpho.model.Aviso;
import zup.proposta.rodolpho.model.Cartao;

import java.time.LocalDate;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AvisoResponse {
    private LocalDate validoAte;
    private String destino;

    public Aviso toModel(Cartao cartao) {
        return new Aviso(validoAte, destino, cartao);
    }
}
