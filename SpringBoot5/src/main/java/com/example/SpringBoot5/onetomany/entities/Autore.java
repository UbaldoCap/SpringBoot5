package com.example.SpringBoot5.onetomany.entities;

import jakarta.persistence.*;

@Entity
public class Autore {
    @Id
    private Long id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "libro_id", nullable = false)
    private Libro libro;

    public Autore(Long id, String nome, Libro libro) {
        this.id = id;
        this.nome = nome;
        this.libro = libro;
    }

    public Autore() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
}

