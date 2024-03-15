package com.example.SpringBoot5.onetomany.controllers;

import com.example.SpringBoot5.onetomany.entities.Autore;
import com.example.SpringBoot5.onetomany.services.AutoreService;
import com.example.SpringBoot5.onetoone.entities.Indirizzo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autore")
public class AutoreController {
    @Autowired
    private AutoreService autoreService;

    @PostMapping("/add")
    public ResponseEntity<Autore> add(@RequestBody Autore autore) {
        return ResponseEntity.ok(autoreService.add(autore));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Autore>> getAll() {
        return ResponseEntity.ok(autoreService.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Autore> get(@PathVariable Long id) {
        Optional<Autore> autoreOptional = autoreService.findById(id);
        if (autoreOptional.isPresent()) {
            return ResponseEntity.ok(autoreOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Autore> update(@RequestBody Autore autore, @PathVariable Long id) {
        Optional<Autore> autoreOptional = autoreService.update(autore, id);
        if (autoreOptional.isPresent()) {
            return ResponseEntity.ok(autoreOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Autore> delete(@PathVariable Long id) {
        Optional<Autore> autoreOptional = autoreService.deleteById(id);
        if (autoreOptional.isPresent()) {
            return ResponseEntity.ok(autoreOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
