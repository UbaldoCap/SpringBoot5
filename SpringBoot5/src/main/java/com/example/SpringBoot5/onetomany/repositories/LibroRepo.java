package com.example.SpringBoot5.onetomany.repositories;

import com.example.SpringBoot5.onetomany.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepo extends JpaRepository<Libro, Long> {
}
