package zup.proposta.rodolpho.controller;

import feign.FeignException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import zup.proposta.rodolpho.controller.form.BloqueioForm;
import zup.proposta.rodolpho.controller.response.BloqueioResponse;
import zup.proposta.rodolpho.model.Bloqueio;
import zup.proposta.rodolpho.model.Cartao;
import zup.proposta.rodolpho.model.CartaoStatus;
import zup.proposta.rodolpho.repository.BloqueioRepository;
import zup.proposta.rodolpho.repository.CartaoRepository;
import zup.proposta.rodolpho.service.CartaoClient;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.net.URI;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("cartoes")
public class BloqueioController {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private BloqueioRepository bloqueioRepository;

    @Autowired
    private CartaoClient cartaoClient;

    @PostMapping("/{cartaoId}/bloqueios")
    public ResponseEntity<?> bloquearCartao(
            @RequestBody @Valid BloqueioForm dto,
            @PathVariable("cartaoId") @NotBlank String cartaoId
    ) {
        Optional<Cartao> possivelCartao = cartaoRepository.findById(cartaoId);

        if(possivelCartao.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Cartao cartao = possivelCartao.get();
        Bloqueio bloqueio = dto.toModel(cartao);
        Map<String, Object> status = null;

        try {
            status = cartaoClient.bloqueia(
                    Map.of("sistemaResponsavel", bloqueio.getSistemaResponsavel()),
                    cartaoId
            );
        } catch (FeignException.FeignClientException.UnprocessableEntity e) {
           return ResponseEntity.unprocessableEntity().build();
        }
        cartao
                .setCartaoStatus(
                        CartaoStatus.valueOf(
                                status.get("resultado").toString()
                        )
                );

        cartaoRepository.save(cartao);
        bloqueioRepository.save(bloqueio);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bloqueio.getId())
                .toUri();

        return ResponseEntity.created(uri).body(status);
    }
}
