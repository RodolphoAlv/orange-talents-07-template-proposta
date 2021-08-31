package zup.proposta.rodolpho.controller;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import zup.proposta.rodolpho.controller.form.NovaCarteiraForm;
import zup.proposta.rodolpho.model.Cartao;
import zup.proposta.rodolpho.model.Carteira;
import zup.proposta.rodolpho.repository.CartaoRepository;
import zup.proposta.rodolpho.repository.CarteiraRepository;
import zup.proposta.rodolpho.service.CartaoClient;

import javax.validation.Valid;
import java.net.URI;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("cartoes")
public class CarteiraController {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private CarteiraRepository carteiraRepository;

    @Autowired
    private CartaoClient cartaoClient;

    @PostMapping("{cartaoId}/carteiras")
    public ResponseEntity<?> associa(
            @Valid @RequestBody NovaCarteiraForm dto,
            @PathVariable("cartaoId") String cartaoId
    ) {
        boolean existeCartao = cartaoRepository.findById(cartaoId).isPresent();

        if(!existeCartao)
            return ResponseEntity.notFound().build();

        Optional<Cartao> possivelCartao = cartaoRepository
                .cartaoSemCarteiraAssociada(cartaoId, dto.getCarteira());

        if(possivelCartao.isEmpty())
            return ResponseEntity.unprocessableEntity().build();

        String resultado = "FALHA";
        Carteira carteira = null;
        Map<String, String> associa;

        try{
            associa = cartaoClient.associa(dto, cartaoId);
            resultado = associa.get("resultado");
        } catch (FeignException.FeignClientException e) {
            return ResponseEntity.unprocessableEntity().build();
        }

        if(resultado.equals("FALHA"))
            return ResponseEntity.unprocessableEntity().build();

        carteira = dto.toModel(
                associa.get("id"),
                dto.getEmail(),
                possivelCartao.get()
        );
        carteiraRepository.save(carteira);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(carteira.getId())
                .toUri();

        return ResponseEntity.created(uri).body(carteira);
    }
}
