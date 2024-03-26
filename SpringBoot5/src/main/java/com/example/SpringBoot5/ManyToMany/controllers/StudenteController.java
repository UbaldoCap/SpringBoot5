package com.example.SpringBoot5.ManyToMany.controllers;

import com.example.SpringBoot5.ManyToMany.Services.StudenteService;
import com.example.SpringBoot5.ManyToMany.entities.Studente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/studente")
public class StudenteController {

    @Autowired
    StudenteService studenteService;

    @PostMapping("/create")
    public ResponseEntity<Studente> create(@RequestBody Studente studente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studenteService.create(studente));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Studente>> findAll() {
        return ResponseEntity.ok(studenteService.findAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Studente> findById(@PathVariable Long id) {
        Optional<Studente> optionalStudente = studenteService.findById(id);
        if (optionalStudente.isPresent()) {
            return ResponseEntity.ok(optionalStudente.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Studente> update(@PathVariable Long id,@RequestBody Studente studente) {
        Optional<Studente> optionalStudente = studenteService.update(id, studente);
        if (optionalStudente.isPresent()) {
            return ResponseEntity.ok(optionalStudente.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Studente> delete(@PathVariable Long id) {
        Optional<Studente> optionalStudente = studenteService.delete(id);
        if (optionalStudente.isPresent()) {
            return ResponseEntity.ok(optionalStudente.get());
        }
        return ResponseEntity.notFound().build();
    }
}

