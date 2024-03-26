package com.example.SpringBoot5.ManyToMany.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Studente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @JsonIgnore
    @ManyToMany(mappedBy = "listaStudenti")
    private List<Corso> listaCorsi;

    public Studente() {
    }

    public Studente(Long id, String nome, List<Corso> listaCorsi) {
        this.id = id;
        this.nome = nome;
        this.listaCorsi = listaCorsi;
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

    public List<Corso> getListaCorsi() {
        return listaCorsi;
    }

    public void setListaCorsi(List<Corso> listaCorsi) {
        this.listaCorsi = listaCorsi;
    }
}
