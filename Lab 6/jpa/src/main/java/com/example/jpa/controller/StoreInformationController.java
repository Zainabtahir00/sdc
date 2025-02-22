package com.example.jpa.controller;

import com.example.jpa.entity.StoreInformation;
import com.example.jpa.repository.StoreInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/stores")
public class StoreInformationController {

    @Autowired
    private StoreInformationRepository storeRepo;

    @PostMapping
    public StoreInformation createStore(@RequestBody StoreInformation store) {
        return storeRepo.save(store);
    }

    @GetMapping
    public List<StoreInformation> getAllStores() {
        return storeRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreInformation> getStoreById(@PathVariable Integer id) {
        StoreInformation store = storeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found with id: " + id));
        return ResponseEntity.ok(store);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StoreInformation> updateStore(@PathVariable Integer id, @RequestBody StoreInformation storeDetails) {
        StoreInformation store = storeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found with id: " + id));
        store.setStoreName(storeDetails.getStoreName());
        store.setStoreDetail(storeDetails.getStoreDetail());
        StoreInformation updatedStore = storeRepo.save(store);
        return ResponseEntity.ok(updatedStore);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteStore(@PathVariable Integer id) {
        StoreInformation store = storeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found with id: " + id));
        storeRepo.delete(store);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
