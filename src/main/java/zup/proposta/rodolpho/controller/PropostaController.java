package zup.proposta.rodolpho.controller;

import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import zup.proposta.rodolpho.controller.dto.ResultadoAnaliseDto;
import zup.proposta.rodolpho.controller.dto.SolicitacaoAnaliseDto;
import zup.proposta.rodolpho.controller.form.NovaPropostaForm;
import zup.proposta.rodolpho.model.Proposta;
import zup.proposta.rodolpho.repository.PropostaRepository;
import zup.proposta.rodolpho.service.SolicitacaoClient;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("propostas")
public class PropostaController {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private SolicitacaoClient solicitacaoClient;

    @Autowired
    private Tracer tracer;

    @PostMapping
    public ResponseEntity<?> cadastrar(
            @RequestBody @Valid NovaPropostaForm dto
    ) {

        Span activeSpan = tracer.activeSpan();

        Optional<Proposta> possivelProposta = propostaRepository.findByDocumento(dto.getDocumento());

        if(possivelProposta.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        activeSpan.setTag("user.email", "rodolpho.alves@zup.com.br");
        activeSpan.log("Teste log: cadastro proposta");

        Proposta proposta = dto.toModel();
        propostaRepository.save(proposta);

        SolicitacaoAnaliseDto solicitacao = SolicitacaoAnaliseDto.toDto(proposta);
        ResultadoAnaliseDto solicitacaoAnalisada = solicitacaoClient.analisa(solicitacao);
        proposta.atualizaStatus(
                solicitacaoAnalisada.getResultadoSolicitacao()
        );

        propostaRepository.save(proposta);

        activeSpan.setBaggageItem("proposta.id", proposta.getId().toString());

        URI localizadoEm = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(proposta.getId())
                .toUri();

        return ResponseEntity.created(localizadoEm).body(proposta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>buscarPorId(@PathVariable("id") Long id) {
        Optional<Proposta> possivelProposta = propostaRepository.findById(id);
        if(possivelProposta.isPresent()) {
            return ResponseEntity.ok(possivelProposta.get());
        }
        
        return ResponseEntity.notFound().build();
    }
}
