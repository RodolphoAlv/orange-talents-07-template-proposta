package zup.proposta.rodolpho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import zup.proposta.rodolpho.controller.dto.SolicitacaoAnaliseDto;
import zup.proposta.rodolpho.controller.response.CartaoResponse;
import zup.proposta.rodolpho.model.Cartao;
import zup.proposta.rodolpho.model.Proposta;
import zup.proposta.rodolpho.repository.CartaoRepository;
import zup.proposta.rodolpho.repository.PropostaRepository;
import zup.proposta.rodolpho.service.CartaoClient;
import zup.proposta.rodolpho.service.SolicitacaoClient;

import java.util.List;
import java.util.Objects;

@Component
public class CartaoController {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private CartaoClient cartaoClient;

    @Autowired
    private CartaoRepository cartaoRepository;

    @Scheduled(fixedRate = 10000L)
    void verificarEmissaoCartao() {

        List<Proposta> propostas = propostaRepository.findAllPropostaCartaoNullStatusElegivel();

        for(Proposta proposta : propostas) {
            CartaoResponse cartaoVerificado = cartaoClient.verifica(SolicitacaoAnaliseDto.toDto(proposta));
            Cartao cartao = cartaoVerificado.toModel(proposta);

            if(Objects.nonNull(cartao.getId())) {
                cartaoRepository.save(cartao);
            }
        }
    }


}
