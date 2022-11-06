package com.principia.principiarh.aplicacao.candidato;

import com.principia.principiarh.infra.candidato.CandidatoEntidadeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidato")
public class CandidatoControlador {

    @Autowired
    private CandidatoServico candidatoServico;

    @PostMapping
    public ResponseEntity<?> cadastrarCandidato(@RequestBody @Valid CandidatoEntidade candidato){
        candidatoServico.cadastrarCandidato(candidato);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarCandidatoPorId(@PathVariable("id") Long idCandidato){
        Optional<CandidatoEntidade> candidatoOptional = candidatoServico.buscarCandidatoPorId(idCandidato);
        if(candidatoOptional.isEmpty()){
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(candidatoOptional.get());

    }

    @GetMapping
    public ResponseEntity<?> buscarTodosOsCandidatos(){
        List<CandidatoEntidade> candidatos = candidatoServico.buscarTodosOsCandidatos();
        return ResponseEntity.ok().body(candidatos);
    }


}
