package com.principia.principiarh.aplicacao.empresa;

import com.principia.principiarh.aplicacao.candidato.CandidatoEntidade;
import com.principia.principiarh.infra.empresa.EmpresaEntidadeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServico {

    @Autowired
    private EmpresaEntidadeRepositorio repositorioDeEmpresa;

    public void cadastrarEmpresa(@Valid EmpresaEntidade empresa){
        repositorioDeEmpresa.save(empresa);
    }

    public Optional<EmpresaEntidade> buscarEmpresaPorId(@NotBlank @Valid Long idEmpresa){
        Optional<EmpresaEntidade> empresaOptional = repositorioDeEmpresa.findById(idEmpresa);
        return empresaOptional;
    }

    public List<EmpresaEntidade> buscarTodasAsEmpresas(){
        List<EmpresaEntidade> empresas = repositorioDeEmpresa.findAll();
        return empresas;
    }
}
