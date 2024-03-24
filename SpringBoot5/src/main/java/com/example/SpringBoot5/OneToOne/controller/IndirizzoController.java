package com.example.SpringBoot5.OneToOne.controller;

import com.example.SpringBoot5.OneToOne.entities.Indirizzo;
import com.example.SpringBoot5.OneToOne.services.IndirizzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/indirizzo")
public class IndirizzoController {
    @Autowired
    private IndirizzoService indirizzoService;

    @PostMapping("/add")
    public ResponseEntity<Indirizzo> add(@RequestBody Indirizzo indirizzo) {
        return ResponseEntity.ok(indirizzoService.add(indirizzo));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Indirizzo>> getAll() {
        return ResponseEntity.ok(indirizzoService.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Indirizzo> get(@PathVariable Long id) {
        Optional<Indirizzo> indirizzoOptional = indirizzoService.findById(id);
        if (indirizzoOptional.isPresent()) {
            return ResponseEntity.ok(indirizzoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Indirizzo> update(@RequestBody Indirizzo indirizzo, @PathVariable Long id) {
        Optional<Indirizzo> indirizzoOptional = indirizzoService.update(indirizzo, id);
        if (indirizzoOptional.isPresent()) {
            return ResponseEntity.ok(indirizzoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Indirizzo> delete(@PathVariable Long id) {
        Optional<Indirizzo> indirizzoOptional = indirizzoService.deleteById(id);
        if (indirizzoOptional.isPresent()) {
            return ResponseEntity.ok(indirizzoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
