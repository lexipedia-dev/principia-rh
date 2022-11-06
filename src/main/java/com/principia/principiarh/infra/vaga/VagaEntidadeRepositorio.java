package com.principia.principiarh.infra.vaga;

import com.principia.principiarh.aplicacao.empresa.EmpresaEntidade;
import com.principia.principiarh.aplicacao.vaga.VagaEntidade;
import com.principia.principiarh.dominio.vaga.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VagaEntidadeRepositorio extends JpaRepository<VagaEntidade, Long> {

    public List<VagaEntidade> findByEmpresa(EmpresaEntidade empresaEntidade);
}
