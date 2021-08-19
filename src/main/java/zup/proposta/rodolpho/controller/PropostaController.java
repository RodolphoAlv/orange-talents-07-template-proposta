package zup.proposta.rodolpho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping
    public ResponseEntity<?> cadastrar(
            @RequestBody @Valid NovaPropostaForm dto
    ) {

        Optional<Proposta> possivelProposta = propostaRepository.findByDocumento(dto.getDocumento());

        if(possivelProposta.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Proposta proposta = dto.toModel();
        propostaRepository.save(proposta);

        SolicitacaoAnaliseDto solicitacao = SolicitacaoAnaliseDto.toDto(proposta);
        ResultadoAnaliseDto solicitacaoAnalisada = solicitacaoClient.analisa(solicitacao);
        proposta.atualizaStatus(
                solicitacaoAnalisada.getResultadoSolicitacao()
        );

        propostaRepository.save(proposta);

        URI localizadoEm = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(proposta.getId())
                .toUri();

        return ResponseEntity.created(localizadoEm).body(proposta);
    }
}
