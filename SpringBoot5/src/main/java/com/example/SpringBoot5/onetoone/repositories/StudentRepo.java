package com.example.SpringBoot5.onetoone.repositories;

import com.example.SpringBoot5.onetoone.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
}
