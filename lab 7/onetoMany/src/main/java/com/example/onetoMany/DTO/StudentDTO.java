package com.example.onetoMany.DTO;

import com.example.onetoMany.DTO.LaptopDTO;

import java.util.List;

public class StudentDTO {
    private int studentId;
    private String studentName;
    private String about;
    private List<LaptopDTO> laptops;

    // Constructor
    public StudentDTO(int studentId, String studentName, String about, List<LaptopDTO> laptops) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.about = about;
        this.laptops = laptops;
    }

    // Default Constructor (needed for serialization)
    public StudentDTO() {}

    // Getters and Setters
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getAbout() { return about; }
    public void setAbout(String about) { this.about = about; }

    public List<LaptopDTO> getLaptops() { return laptops; }
    public void setLaptops(List<LaptopDTO> laptops) { this.laptops = laptops; }
}
