package zup.proposta.rodolpho.controller.form;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import zup.proposta.rodolpho.model.Proposta;
import zup.proposta.rodolpho.validation.CpfOuCnpj;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class NovaPropostaForm {

    @NotBlank
    @CpfOuCnpj
    private String cpfOuCnpj;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String nome;
    @NotNull
    @Positive
    private BigDecimal salario;

    public Proposta toModel() {
        return new Proposta(cpfOuCnpj, email, nome, salario);
    }
}
