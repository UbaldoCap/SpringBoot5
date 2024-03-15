package com.example.SpringBoot5.onetomany.services;

import com.example.SpringBoot5.onetomany.entities.Autore;
import com.example.SpringBoot5.onetomany.entities.Libro;
import com.example.SpringBoot5.onetomany.repositories.AutoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AutoreService {
    @Autowired
    private AutoreRepo autoreRepo;

    public Autore add(Autore autore) {
        return autoreRepo.save(autore);
    }

    public List<Autore> getAll() {
        return autoreRepo.findAll();
    }

    public Optional<Autore> findById(Long id) {
        return autoreRepo.findById(id);
    }

    public Optional<Autore> update(Autore autore, Long id) {
        Optional<Autore> autoreOptional = autoreRepo.findById(id);
        if (autoreOptional.isPresent()) {
            autoreOptional.get().setNome(autore.getNome());
            autoreOptional.get().setLibro(autore.getLibro());
            autoreRepo.save(autoreOptional.get());
            return  autoreOptional;
        } else {
            return Optional.empty();
        }
    }

    public Optional<Autore> deleteById(Long id) {
        Optional<Autore> autoreOptional = autoreRepo.findById(id);
        if (autoreOptional.isPresent()) {
            autoreRepo.deleteById(id);
            return autoreOptional;
        } else {
            return Optional.empty();
        }
    }
}
