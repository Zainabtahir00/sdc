package com.example.onetoMany.repository;
import com.example.onetoMany.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}