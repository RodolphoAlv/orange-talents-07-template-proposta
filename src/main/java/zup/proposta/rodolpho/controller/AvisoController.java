package zup.proposta.rodolpho.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zup.proposta.rodolpho.controller.form.AvisoForm;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("cartoes")
public class AvisoController {

    @PostMapping("{cartaoId}/avisos")
    public ResponseEntity<?> novoAviso(
            AvisoForm dto,
            @RequestHeader("X-Forwarded-For") String clienteIp,
            @RequestHeader("User-Agent") String userAgent,
            @PathVariable("cartaoId") String cartaoId
    ) {

        return ResponseEntity.ok().build();
    }
}
