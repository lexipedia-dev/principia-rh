package com.principia.principiarh.aplicacao.empresa;

import com.principia.principiarh.aplicacao.vaga.VagaEntidade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EMPRESA")
@NoArgsConstructor
public class EmpresaEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    @Getter @Setter private String cnpj;

    @NotBlank
    @Getter @Setter private String nomeFantasia;

    @NotBlank
    @Getter @Setter private String cidade;

    @NotBlank
    @Getter @Setter private String estado;

    @NotBlank
    @Getter @Setter private String endereco;

    @NotBlank
    @Getter @Setter private String bairro;

    @NotBlank
    @Email
    @Getter @Setter private String email;

    @NotBlank
    @Getter @Setter private String telefone1;

    @NotBlank
    @Getter @Setter private String telefone2;

    @OneToMany(mappedBy = "empresa")
    private List<VagaEntidade> vagas = new ArrayList<>();

    public EmpresaEntidade(String cnpj,
                           String nomeFantasia,
                           String cidade,
                           String estado,
                           String endereco,
                           String bairro,
                           String email,
                           String telefone1,
                           String telefone2) {
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.cidade = cidade;
        this.estado = estado;
        this.endereco = endereco;
        this.bairro = bairro;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
    }

    public void criarVaga(VagaEntidade vaga){
        vagas.add(vaga);
    }
}
