package com.principia.principiarh.aplicacao.vaga;

import com.principia.principiarh.aplicacao.empresa.EmpresaEntidade;
import com.principia.principiarh.dominio.empresa.Empresa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import static com.principia.principiarh.aplicacao.vaga.StatusVagaEntidade.FECHADA;

@Entity
@Table(name = "VAGA")
@NoArgsConstructor
public class VagaEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Getter @Setter
    private String nome;
    
    @Enumerated(EnumType.STRING)
    @Getter @Setter private StatusVagaEntidade status;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    @Getter @Setter private EmpresaEntidade empresa;

    public VagaEntidade(String nome, StatusVagaEntidade status, EmpresaEntidade empresa) {
        this.nome = nome;
        this.status = status;
        this.empresa = empresa;
    }

    public void fecharVaga(){
        this.status = FECHADA;
    }
}
