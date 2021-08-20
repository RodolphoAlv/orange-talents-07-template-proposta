package zup.proposta.rodolpho.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import zup.proposta.rodolpho.controller.dto.SolicitacaoAnaliseDto;
import zup.proposta.rodolpho.controller.response.CartaoResponse;

@FeignClient(name = "cartoes", url = "http://localhost:8888/api/")
public interface CartaoClient {

    @PostMapping("cartoes")
    public CartaoResponse verifica(@RequestBody SolicitacaoAnaliseDto dto);
}
