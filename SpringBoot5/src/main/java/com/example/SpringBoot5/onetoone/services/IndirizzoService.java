package com.example.SpringBoot5.onetoone.services;

import com.example.SpringBoot5.onetoone.entities.Indirizzo;
import com.example.SpringBoot5.onetoone.repositories.IndirizzoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IndirizzoService {
    @Autowired
    private IndirizzoRepo indirizzoRepo;

    public Indirizzo add(Indirizzo indirizzo) {
        return indirizzoRepo.save(indirizzo);
    }

    public List<Indirizzo> getAll() {
        return indirizzoRepo.findAll();
    }

    public Optional<Indirizzo> findById(Long id) {
        return indirizzoRepo.findById(id);
    }

    public Optional<Indirizzo> update(Indirizzo indirizzo, Long id) {
        Optional<Indirizzo> indirizzoOptional = indirizzoRepo.findById(id);
        if (indirizzoOptional.isPresent()) {
            indirizzoOptional.get().setVia(indirizzo.getVia());
            indirizzoOptional.get().setCitta(indirizzo.getCitta());
            indirizzoRepo.save(indirizzoOptional.get());
            return  indirizzoOptional;
        } else {
            return Optional.empty();
        }
    }

    public Optional<Indirizzo> deleteById(Long id) {
        Optional<Indirizzo> indirizzoOptional = indirizzoRepo.findById(id);
        if (indirizzoOptional.isPresent()) {
            indirizzoRepo.deleteById(id);
            return indirizzoOptional;
        } else {
            return Optional.empty();
        }
    }

}
