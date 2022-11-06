package com.principia.principiarh.dominio.empresa;

import com.principia.principiarh.dominio.vaga.Vaga;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private String cnpj;
    private String nomeFantasia;
    private String cidade;
    private String estado;
    private String endereco;
    private String bairro;
    private String email;
    private String telefone1;
    private String telefone2;
    private List<Vaga> vagas = new ArrayList<>();

    public Empresa() {
    }

    public Empresa(String cnpj,
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public void criarVaga(Vaga vaga){
        this.vagas.add(vaga);
    }

}
