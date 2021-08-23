package zup.proposta.rodolpho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import zup.proposta.rodolpho.controller.form.NovaBiometriaForm;
import zup.proposta.rodolpho.model.Biometria;
import zup.proposta.rodolpho.model.Cartao;
import zup.proposta.rodolpho.repository.BiometriaRepository;
import zup.proposta.rodolpho.repository.CartaoRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("biometria")
public class BiometriaController {

    @Autowired
    private BiometriaRepository biometriaRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @PostMapping("/{id}")
    public ResponseEntity<?> criar(
            @Valid @RequestBody NovaBiometriaForm dto,
            @PathVariable("id") String cartaoId
    ) {
        Optional<Cartao> possivelCartao = cartaoRepository.findById(cartaoId);
        if(possivelCartao.isPresent()) {
            Biometria biometria = dto.toModel(possivelCartao.get());
            biometriaRepository.save(biometria);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(biometria.getId())
                    .toUri();

            return ResponseEntity.created(uri).body(biometria);
        }

        return ResponseEntity.notFound().build();
    }
}
