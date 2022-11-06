package com.principia.principiarh.dominio.candidato;

import com.principia.principiarh.dominio.vaga.Vaga;

import java.util.List;

public class Candidato {

    private String nome;
    private String email;
    private String telefone1;
    private String telefone2;
    private String estado;
    private String cidade;
    private String endereco;
    private String bairro;

    private List<Vaga> vagas;

    public Candidato() {
    }

    public Candidato(String nome,
                     String email,
                     String telefone1,
                     String telefone2,
                     String estado,
                     String cidade,
                     String endereco,
                     String bairro) {
        this.nome = nome;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.estado = estado;
        this.cidade = cidade;
        this.endereco = endereco;
        this.bairro = bairro;
    }

    public void cadastraVaga(Vaga vaga){
        this.vagas.add(vaga);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
