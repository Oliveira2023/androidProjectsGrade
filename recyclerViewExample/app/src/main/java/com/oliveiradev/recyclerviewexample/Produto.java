package com.oliveiradev.recyclerviewexample;

public class Produto {
    private String descr;
    private double valor;

    public Produto(String descr, double valor) {
        this.descr = descr;
        this.valor = valor;
    }

    public String getDescr() {
        return descr;
    }

    public double getValor() {
        return valor;
    }
}
