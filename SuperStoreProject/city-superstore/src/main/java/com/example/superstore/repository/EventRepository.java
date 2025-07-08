package com.example.superstore.repository;

import com.example.superstore.model.Event;
import com.example.superstore.model.Store;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByStore(Store store);
}