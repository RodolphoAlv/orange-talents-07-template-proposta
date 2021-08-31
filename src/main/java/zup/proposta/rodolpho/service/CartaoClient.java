package zup.proposta.rodolpho.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import zup.proposta.rodolpho.controller.dto.SolicitacaoAnaliseDto;
import zup.proposta.rodolpho.controller.form.AvisoForm;
import zup.proposta.rodolpho.controller.form.NovaCarteiraForm;
import zup.proposta.rodolpho.controller.response.CartaoResponse;

import java.util.Map;

@FeignClient(name = "cartoes", url = "http://localhost:8888/api/cartoes/")
public interface CartaoClient {

    @PostMapping
    public CartaoResponse verifica(@RequestBody SolicitacaoAnaliseDto dto);

    @PostMapping("{cartaoId}/bloqueios")
    public Map<String, Object> bloqueia(
            @RequestBody Map<String, String> sistemaResponsavel,
            @PathVariable("cartaoId") String cartaoId
    );

    @PostMapping("{cartaoId}/avisos")
    public Map<String, String> avisa(
            @RequestBody AvisoForm dto,
            @PathVariable("cartaoId") String cartaoId
    );

    @PostMapping("{cartaoId}/carteiras")
    public Map<String, String> associa(
            @RequestBody NovaCarteiraForm dto,
            @PathVariable("cartaoId") String cartaoId
    );
}
