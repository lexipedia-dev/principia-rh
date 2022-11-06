package com.principia.principiarh.infra.empresa;

import com.principia.principiarh.aplicacao.empresa.EmpresaEntidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaEntidadeRepositorio extends JpaRepository<EmpresaEntidade, Long> {
}
