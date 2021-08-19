package zup.proposta.rodolpho.controller.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ResultadoAnaliseDto {

    private String documento;
    private String nome;
    private String resultadoSolicitacao;
    private String idProposta;

    public String getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }
}
