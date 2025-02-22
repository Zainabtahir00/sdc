package com.example.jpa.entity;

import jakarta.persistence.*;

@Entity

public class StoreInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for MySQL
    private Integer storeId;

    private String storeName;
    private String storeDetail;
    private String phoneNo;

    // Default constructor (important for JPA)
    public StoreInformation() {}

    // Parameterized constructor
    public StoreInformation(Integer storeId, String storeName, String storeDetail, String phoneNo) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.storeDetail = storeDetail;
        this.phoneNo = phoneNo;
    }

    // Getters and Setters
    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreDetail() {
        return storeDetail;
    }

    public void setStoreDetail(String storeDetail) {
        this.storeDetail = storeDetail;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
