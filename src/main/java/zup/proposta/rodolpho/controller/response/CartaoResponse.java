package zup.proposta.rodolpho.controller.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import zup.proposta.rodolpho.model.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CartaoResponse {
    private String id;
    private LocalDateTime emitidoEm;
    private String titular;
    private List<BloqueioResponse> bloqueios;
    private List<AvisoResponse> avisos;
    private List<CarteiraResponse> carteiras;
    private List<ParcelaResponse> parcelas;
    private BigDecimal limite;
    private Renegociacao renegociacao;
    private VencimentoResponse vencimento;
    private String propostaId;

    public Cartao toModel(Proposta proposta) {

        Cartao cartaoGuia = new Cartao(id);

        List<Bloqueio> bloqueios = this.bloqueios
                .stream()
                .map(bloqueio -> bloqueio.toModel(cartaoGuia))
                .collect(Collectors.toList());

        List<Aviso> avisos = this.avisos
                .stream()
                .map(aviso -> aviso.toModel(cartaoGuia))
                .collect(Collectors.toList());

        List<Carteira> carteiras = this.carteiras
                .stream()
                .map(carteira -> carteira.toModel(cartaoGuia))
                .collect(Collectors.toList());

        List<Parcela> parcelas = this.parcelas
                .stream()
                .map(parcela -> parcela.toModel(cartaoGuia))
                .collect(Collectors.toList());

        return new Cartao(
            id,
            emitidoEm,
            titular,
            bloqueios,
            avisos,
            carteiras,
            parcelas,
            limite,
            renegociacao,
            vencimento.toModel(cartaoGuia),
            proposta
        );
    }
}
