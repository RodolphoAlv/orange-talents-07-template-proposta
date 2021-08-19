package zup.proposta.rodolpho.controller.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import zup.proposta.rodolpho.model.Proposta;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SolicitacaoAnaliseDto {

    private String documento;
    private String nome;
    private String idProposta;

    private SolicitacaoAnaliseDto(String documento, String nome, String idProposta) {
        this.documento = documento;
        this.nome = nome;
        this.idProposta = idProposta;
    }

    public static SolicitacaoAnaliseDto toDto(Proposta proposta) {
        return new SolicitacaoAnaliseDto(
                proposta.getDocumento(),
                proposta.getNome(),
                proposta.getId().toString()
        );
    }
}
