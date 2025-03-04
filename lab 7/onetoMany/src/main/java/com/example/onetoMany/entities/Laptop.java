package com.example.onetoMany.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "jpa_laptop")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int laptopId;
    private String modelNumber;
    private String brand;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private Student student;

    // Constructors, Getters, and Setters
    public Laptop() {}

    public Laptop(String modelNumber, String brand, Student student) {
        this.modelNumber = modelNumber;
        this.brand = brand;
        this.student = student;
    }

    public int getLaptopId() { return laptopId; }
    public void setLaptopId(int laptopId) { this.laptopId = laptopId; }

    public String getModelNumber() { return modelNumber; }
    public void setModelNumber(String modelNumber) { this.modelNumber = modelNumber; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
}


