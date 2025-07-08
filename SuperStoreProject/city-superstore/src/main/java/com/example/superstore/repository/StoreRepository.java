package com.example.superstore.repository;

import com.example.superstore.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Store findByCode(String code);
}