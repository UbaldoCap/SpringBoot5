package com.example.SpringBoot5.ManyToMany.repositories;

import com.example.SpringBoot5.ManyToMany.entities.Corso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorsoRepository extends JpaRepository<Corso, Long> {
}
