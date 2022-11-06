package com.principia.principiarh.aplicacao.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

@RestController
@RequestMapping("/empresa")
public class EmpresaControlador {

    @Autowired
    private EmpresaServico empresaServico;

    @PostMapping
    public ResponseEntity<?> cadastrarEmpresa(@Valid @RequestBody EmpresaEntidade empresa){
        empresaServico.cadastrarEmpresa(empresa);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarEmpresaPorId(@PathVariable("id") @NotBlank Long idEmpresa){
        Optional<EmpresaEntidade> empresaOptional = empresaServico.buscarEmpresaPorId(idEmpresa);
        if(empresaOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(empresaOptional.get());
    }




}
