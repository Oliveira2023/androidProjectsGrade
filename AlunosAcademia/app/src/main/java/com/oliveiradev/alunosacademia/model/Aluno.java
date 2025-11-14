package com.oliveiradev.alunosacademia.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class Aluno {

    private int ID;
    private String nome;
    private int idade;
    private double altura;
    private double peso;
    private String unidade;

    /**
     * An array of sample (placeholder) items.
     */
    public static final List<Aluno> ALUNOS = new ArrayList<Aluno>();


    public Aluno (String nome, int idade, double altura, double peso, String unidade) {
        this.ID = ALUNOS.size();
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.unidade = unidade;
    }

    public Aluno (String nome, int idade, String unidade) {
        this.ID = ALUNOS.size();
        this.nome = nome;
        this.idade = idade;
        this.unidade = unidade;
    }
    public Aluno (){}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return ID == aluno.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ID);
    }
}