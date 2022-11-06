package com.principia.principiarh.aplicacao.candidato;

import com.principia.principiarh.aplicacao.vaga.VagaEntidade;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CANDIDATO")
@NoArgsConstructor
public class CandidatoEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    @Getter @Setter private String nome;

    @Email
    @NotBlank
    @Getter @Setter private String email;

    @NotBlank
    @Getter @Setter private String telefone1;

    @NotBlank
    @Getter @Setter private String telefone2;

    @NotBlank
    @Getter @Setter private String estado;

    @NotBlank
    @Getter @Setter private String cidade;

    @NotBlank
    @Getter @Setter private String endereco;

    @NotBlank
    @Getter @Setter private String bairro;

    @Getter @ManyToMany private List<VagaEntidade> vagas = new ArrayList<>();

    public CandidatoEntidade(String nome, String email, String telefone1, String telefone2, String estado, String cidade, String endereco, String bairro) {
        this.nome = nome;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.estado = estado;
        this.cidade = cidade;
        this.endereco = endereco;
        this.bairro = bairro;
    }

    public void candidatarNaVaga(VagaEntidade vaga){
        this.vagas.add(vaga);
    }
}
