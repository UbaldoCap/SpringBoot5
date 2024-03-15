package com.example.SpringBoot5.onetomany.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titolo;

    @OneToMany(mappedBy = "libro")
    private List<Autore> autori;

    public Libro(Long id, String titolo) {
        this.id = id;
        this.titolo = titolo;
        autori = new ArrayList<>();
    }

    public Libro() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public List<Autore> getAutori() {
        return autori;
    }
}
