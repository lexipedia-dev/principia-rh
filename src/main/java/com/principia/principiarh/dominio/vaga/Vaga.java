package com.principia.principiarh.dominio.vaga;

import com.principia.principiarh.dominio.candidato.Candidato;
import com.principia.principiarh.dominio.candidato.NotificadorDeCandidatos;
import com.principia.principiarh.dominio.empresa.Empresa;

import java.util.ArrayList;
import java.util.List;

import static com.principia.principiarh.dominio.vaga.Status.ABERTA;
import static com.principia.principiarh.dominio.vaga.Status.FECHADA;

public class Vaga {

    private Empresa empresa;
    private String nome;
    private List<Candidato> candidatos = new ArrayList<>();
    private Status statusVaga = ABERTA;

    public void fecharVaga(Candidato candidatoAprovado){
        this.statusVaga = FECHADA;
        List<Candidato> candidatosReprovados = new ArrayList<>();

        for (Candidato candidato:
             candidatos) {
            candidatosReprovados.add(candidato);
        }

        candidatosReprovados.remove(candidatoAprovado);

        NotificadorDeCandidatos notificadorDeCandidatos = null;
        notificadorDeCandidatos.notificarUnicoCandidatoAprovado(candidatoAprovado);
        notificadorDeCandidatos.notificarMultiplosCandidatosReprovados(candidatosReprovados);
    }

    public void fecharVaga(List<Candidato> candidatosAprovados){
        this.statusVaga = FECHADA;
        List<Candidato> candidatosReprovados = new ArrayList<>();

        for (Candidato candidato:
                candidatos) {
            candidatosReprovados.add(candidato);
        }

        candidatosReprovados.removeAll(candidatosAprovados);

        NotificadorDeCandidatos notificadorDeCandidatos = null;
        notificadorDeCandidatos.notificarMultiplosCandidatosReprovados(candidatosAprovados);
        notificadorDeCandidatos.notificarMultiplosCandidatosReprovados(candidatosReprovados);

    }


}
