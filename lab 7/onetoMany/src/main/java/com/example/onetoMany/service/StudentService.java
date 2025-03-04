package com.example.onetoMany.service;

import com.example.onetoMany.DTO.LaptopDTO;
import com.example.onetoMany.DTO.StudentDTO;
import com.example.onetoMany.entities.Student;
import com.example.onetoMany.entities.Laptop;
import com.example.onetoMany.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    // Convert Entity to DTO
    private StudentDTO convertToDTO(Student student) {
        List<LaptopDTO> laptopDTOs = student.getLaptops().stream()
                .map(laptop -> new LaptopDTO(laptop.getLaptopId(), laptop.getModelNumber(), laptop.getBrand()))
                .collect(Collectors.toList());

        return new StudentDTO(student.getStudentId(), student.getStudentName(), student.getAbout(), laptopDTOs);
    }

    // Get All Students
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get Student by ID
    public StudentDTO getStudentById(int id) {
        return studentRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    // Save Student
    public StudentDTO saveStudent(Student student) {
        student.getLaptops().forEach(laptop -> laptop.setStudent(student)); // Fix One-to-Many Relation
        Student savedStudent = studentRepository.save(student);
        return convertToDTO(savedStudent);
    }
}
