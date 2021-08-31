package zup.proposta.rodolpho.controller.form;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import zup.proposta.rodolpho.model.Cartao;
import zup.proposta.rodolpho.model.Carteira;
import zup.proposta.rodolpho.validation.CarteiraValida;


import javax.validation.constraints.NotBlank;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class NovaCarteiraForm {
    @NotBlank
    public String email;
    @CarteiraValida(fieldName = "carteira")
    public String carteira;

    public String getCarteira() {
        return carteira;
    }

    public String getEmail() {
        return email;
    }

    public Carteira toModel(String id, String email, Cartao cartao) {
        return new Carteira(id, email, cartao, carteira);
    }
}
