package com.example.SpringBoot5.ManyToMany.repositories;

import com.example.SpringBoot5.ManyToMany.entities.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudenteRepository extends JpaRepository<Studente, Long> {
}
