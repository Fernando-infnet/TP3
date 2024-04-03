package com.example.demo.api.model;

public class Professor {
    private static int proximoID = 1;
    private int id;
    private String nome;
    private int idEscola;

    public Professor() {

    }
    
    public Professor(String nome, int idEscola) {
        this.id = proximoID++;
        this.nome = nome;
        this.idEscola = idEscola;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdEscola() {
        return idEscola;
    }

    public void setIdEscola(int idEscola) {
        this.idEscola = idEscola;
    }
}