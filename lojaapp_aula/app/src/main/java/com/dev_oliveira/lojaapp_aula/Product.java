package com.dev_oliveira.lojaapp_aula;

public class Product {

    private String descricao;
    private double preco;
    private int imagRes;

    public Product(String descricao, float preco, int imagRes) {
        this.descricao = descricao;
        this.preco = preco;
        this.imagRes = imagRes;
    }
    public Product(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }
    public int getImagRes() {
        return imagRes;
    }
}
