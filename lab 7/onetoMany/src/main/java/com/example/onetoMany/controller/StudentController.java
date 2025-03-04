package com.example.onetoMany.controller;
import com.example.onetoMany.DTO.StudentDTO;
import com.example.onetoMany.entities.Student;
import com.example.onetoMany.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/onetomany")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public StudentDTO saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
}


