package zup.proposta.rodolpho.controller.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import zup.proposta.rodolpho.model.Cartao;
import zup.proposta.rodolpho.model.Carteira;

import java.time.LocalDateTime;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CarteiraResponse {
    private String id;
    private String email;
    private LocalDateTime associadaEm;
    private String emissor;

    public Carteira toModel(Cartao cartao) {
        return new Carteira(id, email, associadaEm, emissor, cartao, null);
    }
}
