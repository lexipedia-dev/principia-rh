package com.principia.principiarh.dominio.candidato;

import java.util.List;

public interface NotificadorDeCandidatos {

    public void notificarUnicoCandidatoAprovado(Candidato candidato);

    public void notificarMultiplosCandidatosAprovados(List<Candidato> candidatos);

    public void notificarMultiplosCandidatosReprovados(List<Candidato> candidatos);
}
