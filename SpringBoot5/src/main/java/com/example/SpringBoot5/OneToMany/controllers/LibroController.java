package com.example.SpringBoot5.OneToMany.controllers;

import com.example.SpringBoot5.OneToMany.entities.Libro;
import com.example.SpringBoot5.OneToMany.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libro")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @PostMapping("/add")
    public ResponseEntity<Libro> add(@RequestBody Libro libro) {
        return ResponseEntity.ok(libroService.add(libro));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Libro>> getAll() {
        return ResponseEntity.ok(libroService.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Libro> get(@PathVariable Long id) {
        Optional<Libro> libroOptional = libroService.findById(id);
        if (libroOptional.isPresent()) {
            return ResponseEntity.ok(libroOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Libro> update(@RequestBody Libro libro, @PathVariable Long id) {
        Optional<Libro> libroOptional = libroService.update(libro, id);
        if (libroOptional.isPresent()) {
            return ResponseEntity.ok(libroOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Libro> delete(@PathVariable Long id) {
        Optional<Libro> libroOptional = libroService.deleteById(id);
        if (libroOptional.isPresent()) {
            return ResponseEntity.ok(libroOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
