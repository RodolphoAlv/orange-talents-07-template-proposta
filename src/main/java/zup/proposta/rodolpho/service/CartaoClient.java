package zup.proposta.rodolpho.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import zup.proposta.rodolpho.controller.dto.SolicitacaoAnaliseDto;
import zup.proposta.rodolpho.controller.form.AvisoForm;
import zup.proposta.rodolpho.controller.response.CartaoResponse;

import java.util.Map;

@FeignClient(name = "cartoes", url = "http://localhost:8888/api/")
public interface CartaoClient {

    @PostMapping("cartoes")
    public CartaoResponse verifica(@RequestBody SolicitacaoAnaliseDto dto);

    @PostMapping("cartoes/{cartaoId}/bloqueios")
    public Map<String, Object> bloqueia(
            @RequestBody Map<String, String> sistemaResponsavel,
            @PathVariable("cartaoId") String cartaoId
    );

    @PostMapping("cartoes/{cartaoId}/avisos")
    public Map<String, String> avisa(
            @RequestBody AvisoForm dto,
            @PathVariable("cartaoId") String cartaoId
    );
}
