package com.example.onetoMany.DTO;

public class LaptopDTO {
    private int laptopId;
    private String modelNumber;
    private String brand;

    // Constructor
    public LaptopDTO(int laptopId, String modelNumber, String brand) {
        this.laptopId = laptopId;
        this.modelNumber = modelNumber;
        this.brand = brand;
    }

    // Default Constructor (needed for serialization)
    public LaptopDTO() {}

    // Getters and Setters
    public int getLaptopId() { return laptopId; }
    public void setLaptopId(int laptopId) { this.laptopId = laptopId; }

    public String getModelNumber() { return modelNumber; }
    public void setModelNumber(String modelNumber) { this.modelNumber = modelNumber; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
}
