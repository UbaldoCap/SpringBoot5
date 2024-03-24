package com.example.SpringBoot5.OneToMany.repositories;

import com.example.SpringBoot5.OneToMany.entities.Autore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoreRepo extends JpaRepository<Autore, Long> {
}
