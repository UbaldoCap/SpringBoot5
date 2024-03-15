package com.example.SpringBoot5.onetoone.services;

import com.example.SpringBoot5.onetoone.entities.Student;
import com.example.SpringBoot5.onetoone.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public Student add(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    public Optional<Student> findById(Long id) {
        return studentRepo.findById(id);
    }

    public Optional<Student> update(Student student, Long id) {
        Optional<Student> studentOptional = studentRepo.findById(id);
        if (studentOptional.isPresent()) {
            studentOptional.get().setNome(student.getNome());
            studentOptional.get().setIndirizzo(student.getIndirizzo());
            studentRepo.save(studentOptional.get());
            return  studentOptional;
        } else {
            return Optional.empty();
        }
    }

    public Optional<Student> deleteById(Long id) {
        Optional<Student> studentOptional = studentRepo.findById(id);
        if (studentOptional.isPresent()) {
            studentRepo.deleteById(id);
            return studentOptional;
        } else {
            return Optional.empty();
        }
    }
}
