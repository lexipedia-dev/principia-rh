package com.principia.principiarh.aplicacao.candidato;

import com.principia.principiarh.infra.candidato.CandidatoEntidadeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class CandidatoServico {

    @Autowired
    private CandidatoEntidadeRepositorio repositorioDeCandidatos;

    public void cadastrarCandidato(@Valid CandidatoEntidade candidato){

        repositorioDeCandidatos.save(candidato);
    }

    public Optional<CandidatoEntidade> buscarCandidatoPorId(Long idCandidato){
        Optional<CandidatoEntidade> candidatoOptional = repositorioDeCandidatos.findById(idCandidato);
        return candidatoOptional;
    }

    public List<CandidatoEntidade> buscarTodosOsCandidatos(){
        List<CandidatoEntidade> candidatos = repositorioDeCandidatos.findAll();
        return candidatos;
    }
}
