package com.example.SpringBoot5.ManyToMany.controllers;

import com.example.SpringBoot5.ManyToMany.Services.CorsoService;
import com.example.SpringBoot5.ManyToMany.entities.Corso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/corso")
public class CorsoController {

    @Autowired
    CorsoService corsoService;

    @PostMapping("/create")
    public ResponseEntity<Corso> create(@RequestBody Corso corso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(corsoService.create(corso));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Corso>> findAll() {
        return ResponseEntity.ok(corsoService.findAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Corso> findById(@PathVariable Long id) {
        Optional<Corso> optionalCorso = corsoService.findById(id);
        if (optionalCorso.isPresent()) {
            return ResponseEntity.ok(optionalCorso.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Corso> update(@PathVariable Long id, @RequestBody Corso corso) {
        Optional<Corso> optionalCorso = corsoService.update(id, corso);
        if (optionalCorso.isPresent()) {
            return ResponseEntity.ok(optionalCorso.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Corso> delete(@PathVariable Long id) {
        Optional<Corso> optionalCorso = corsoService.delete(id);
        if (optionalCorso.isPresent()) {
            return ResponseEntity.ok(optionalCorso.get());
        }
        return ResponseEntity.notFound().build();
    }
}
