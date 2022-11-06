package com.principia.principiarh.aplicacao.vaga;

import com.principia.principiarh.aplicacao.empresa.EmpresaEntidade;
import com.principia.principiarh.aplicacao.empresa.EmpresaServico;
import com.principia.principiarh.infra.vaga.VagaEntidadeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class VagaServico {

    @Autowired
    private VagaEntidadeRepositorio repositorioDeVaga;

    @Autowired
    private EmpresaServico empresaServico;

    public void criarVaga(@Valid VagaEntidade vaga, Long idEmpresa) throws Exception {
        vaga.setStatus(StatusVagaEntidade.ABERTA);
        EmpresaEntidade empresa = validaEmpresa(idEmpresa);
        vaga.setEmpresa(empresa);
        repositorioDeVaga.save(vaga);
    }

    private EmpresaEntidade validaEmpresa(Long idEmpresa) throws Exception {
        Optional<EmpresaEntidade> empresaOptional = empresaServico.buscarEmpresaPorId(idEmpresa);
        if(empresaOptional.isEmpty()){
            throw new Exception("Empresa não encontrada");
        }
        EmpresaEntidade empresa = empresaOptional.get();
        return empresa;
    }

    public Optional<VagaEntidade> buscarVagaPorId(@NotNull Long idVaga){
        Optional<VagaEntidade> vagaOptional = repositorioDeVaga.findById(idVaga);
        return vagaOptional;
    }

    public List<VagaEntidade> buscarVagasPorEmpresa(@Valid EmpresaEntidade empresa){

        List<VagaEntidade> empresas = repositorioDeVaga.findByEmpresa(empresa);
        return empresas;
    }

    public void fecharVaga(Long idVaga) throws Exception {
        Optional<VagaEntidade> vaga = repositorioDeVaga.findById(idVaga);
        if(vaga.isEmpty()){
            throw new Exception("Vaga não encontrada");
        }
        vaga.get().fecharVaga();
        repositorioDeVaga.save(vaga.get());
    }
}
