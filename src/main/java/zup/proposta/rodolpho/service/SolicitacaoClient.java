package zup.proposta.rodolpho.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import zup.proposta.rodolpho.controller.dto.ResultadoAnaliseDto;
import zup.proposta.rodolpho.controller.dto.SolicitacaoAnaliseDto;

import javax.validation.Valid;

@FeignClient(name = "solicitacao", url = "http://localhost:9999/api/")
public interface SolicitacaoClient {
    @PostMapping("solicitacao")
    ResultadoAnaliseDto analisa(@RequestBody @Valid SolicitacaoAnaliseDto dto);
}
