package com.example.SpringBoot5.ManyToMany.Services;

import com.example.SpringBoot5.ManyToMany.entities.Corso;
import com.example.SpringBoot5.ManyToMany.repositories.CorsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CorsoService {
    @Autowired
    CorsoRepository corsoRepository;

    public Corso create(Corso corso) {
        return corsoRepository.save(corso);
    }

    public List<Corso> findAll() {
        return corsoRepository.findAll();
    }

    public Optional<Corso> findById(Long id) {
        return corsoRepository.findById(id);
    }

    public Optional<Corso> update(Long id, Corso corso) {
        Optional<Corso> optionalCorso = corsoRepository.findById(id);
        if (optionalCorso.isPresent()) {
            optionalCorso.get().setNome(corso.getNome());
            return Optional.of(corsoRepository.save(optionalCorso.get()));
        }
        return Optional.empty();
    }

    public Optional<Corso> delete(Long id) {
        Optional<Corso> optionalCorso = corsoRepository.findById(id);
        if (optionalCorso.isPresent()) {
            corsoRepository.deleteById(id);
            return optionalCorso;
        }
        return Optional.empty();
    }
}
