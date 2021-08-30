package zup.proposta.rodolpho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zup.proposta.rodolpho.controller.form.AvisoForm;
import zup.proposta.rodolpho.model.Aviso;
import zup.proposta.rodolpho.model.Cartao;
import zup.proposta.rodolpho.repository.AvisoRepository;
import zup.proposta.rodolpho.repository.CartaoRepository;
import zup.proposta.rodolpho.service.CartaoClient;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("cartoes")
public class AvisoController {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private CartaoClient cartaoClient;

    @Autowired
    private AvisoRepository avisoRepository;

    @PostMapping("{cartaoId}/avisos")
    public ResponseEntity<?> novoAviso(
            @Valid @RequestBody AvisoForm dto,
            @RequestHeader("X-Forwarded-For") String ipCliente,
            @RequestHeader("User-Agent") String userAgent,
            @PathVariable("cartaoId") String cartaoId
    ) {

        Optional<Cartao> possivelCartao = cartaoRepository.findById(cartaoId);
        if(possivelCartao.isEmpty())
            return ResponseEntity.notFound().build();

        Map<String, String> respostaAviso = cartaoClient.avisa(dto, cartaoId);

        String resultado = respostaAviso.get("resultado");

        if(!resultado.equals("CRIADO")) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Aviso aviso = dto.toModel(possivelCartao.get(), userAgent, ipCliente);
        avisoRepository.save(aviso);
        return ResponseEntity.ok(aviso);
    }
}
