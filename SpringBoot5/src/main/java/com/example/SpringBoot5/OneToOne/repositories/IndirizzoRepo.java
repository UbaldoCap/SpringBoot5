package com.example.SpringBoot5.OneToOne.repositories;

import com.example.SpringBoot5.OneToOne.entities.Indirizzo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndirizzoRepo extends JpaRepository<Indirizzo, Long> {
}
