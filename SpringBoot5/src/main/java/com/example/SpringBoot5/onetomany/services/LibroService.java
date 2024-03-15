package com.example.SpringBoot5.onetomany.services;

import com.example.SpringBoot5.onetomany.entities.Libro;
import com.example.SpringBoot5.onetomany.repositories.LibroRepo;
import com.example.SpringBoot5.onetoone.entities.Indirizzo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    private LibroRepo libroRepo;

    public Libro add(Libro libro) {
        return libroRepo.save(libro);
    }

    public List<Libro> getAll() {
        return libroRepo.findAll();
    }

    public Optional<Libro> findById(Long id) {
        return libroRepo.findById(id);
    }

    public Optional<Libro> update(Libro libro, Long id) {
        Optional<Libro> libroOptional = libroRepo.findById(id);
        if (libroOptional.isPresent()) {
            libroOptional.get().setTitolo(libro.getTitolo());
            libroRepo.save(libroOptional.get());
            return  libroOptional;
        } else {
            return Optional.empty();
        }
    }

    public Optional<Libro> deleteById(Long id) {
        Optional<Libro> libroOptional = libroRepo.findById(id);
        if (libroOptional.isPresent()) {
            libroRepo.deleteById(id);
            return libroOptional;
        } else {
            return Optional.empty();
        }
    }
}
