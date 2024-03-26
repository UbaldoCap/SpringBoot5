package com.example.SpringBoot5.ManyToMany.Services;

import com.example.SpringBoot5.ManyToMany.entities.Studente;
import com.example.SpringBoot5.ManyToMany.repositories.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudenteService {
    @Autowired
    StudenteRepository studenteRepository;

    public Studente create(Studente studente) {
        return studenteRepository.save(studente);
    }

    public List<Studente> findAll() {
        return studenteRepository.findAll();
    }

    public Optional<Studente> findById(Long id) {
        return studenteRepository.findById(id);
    }

    public Optional<Studente> update(Long id, Studente studente) {
        Optional<Studente> optionalStudente = studenteRepository.findById(id);
        if (optionalStudente.isPresent()) {
            optionalStudente.get().setNome(studente.getNome());
            return Optional.of(studenteRepository.save(optionalStudente.get()));
        }
        return Optional.empty();
    }

    public Optional<Studente> delete(Long id) {
        Optional<Studente> optionalStudente = studenteRepository.findById(id);
        if (optionalStudente.isPresent()) {
            studenteRepository.deleteById(id);
            return optionalStudente;
        }
        return Optional.empty();
    }
}
