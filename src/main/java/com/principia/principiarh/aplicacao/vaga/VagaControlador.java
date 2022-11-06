package com.principia.principiarh.aplicacao.vaga;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@RequestMapping("/vaga")
public class VagaControlador {

    @Autowired
    private VagaServico vagaServico;

    @SneakyThrows
    @PostMapping("/empresa/{idEmpresa}")
    public ResponseEntity<?> cadastrarVaga(@Valid @RequestBody VagaEntidade vaga,
                                           @PathVariable("idEmpresa") Long idEmpresa){
        vagaServico.criarVaga(vaga, idEmpresa);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarVagaPorId(@PathVariable("id") @NotNull Long idVaga){
        Optional<VagaEntidade> vagaOptional = vagaServico.buscarVagaPorId(idVaga);
        if(vagaOptional.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(vagaOptional.get());
    }

    @SneakyThrows
    @PutMapping("/{id}")
    public ResponseEntity<?> fecharVaga(@PathVariable("id") @NotNull Long idVaga){
        vagaServico.fecharVaga(idVaga);
        return ResponseEntity.ok().build();
    }
}
