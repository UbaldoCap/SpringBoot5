package com.example.SpringBoot5.onetoone.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Indirizzo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String via;
    private String citta;

    public Indirizzo(Long id, String via) {
        this.id = id;
        this.via = via;
        this.citta = "prova";
    }

    public Indirizzo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }
}
