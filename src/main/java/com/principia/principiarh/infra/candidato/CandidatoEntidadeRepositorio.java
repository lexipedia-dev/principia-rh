package com.principia.principiarh.infra.candidato;


import com.principia.principiarh.aplicacao.candidato.CandidatoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoEntidadeRepositorio extends JpaRepository<CandidatoEntidade, Long> {
}
