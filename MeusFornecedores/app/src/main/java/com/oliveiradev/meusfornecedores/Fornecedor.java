package com.oliveiradev.meusfornecedores;

public class Fornecedor {

    private String cnpj;
    private String razaoSocial;
    private String localizacao;
    private String telefone;

    public Fornecedor(String cnpj, String razaoSocial, String localizacao, String telefone) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.localizacao = localizacao;
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
