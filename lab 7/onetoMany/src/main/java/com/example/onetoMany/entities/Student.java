package com.example.onetoMany.entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "jpa_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String studentName;
    private String about;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Laptop> laptops;

    // Constructors, Getters, and Setters
    public Student() {}

    public Student(String studentName, String about, List<Laptop> laptops) {
        this.studentName = studentName;
        this.about = about;
        this.laptops = laptops;
    }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getAbout() { return about; }
    public void setAbout(String about) { this.about = about; }

    public List<Laptop> getLaptops() { return laptops; }
    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
        for (Laptop laptop : laptops) {
            laptop.setStudent(this); // Maintain bidirectional mapping
        }
    }
}




