package com.example.jpa.repository;
import com.example.jpa.entity.StoreInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreInformationRepository extends JpaRepository<StoreInformation, Integer> {
        // Custom query methods can be added here
    }

