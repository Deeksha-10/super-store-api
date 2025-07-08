package com.example.superstore.repository;

import com.example.superstore.model.Registration;
import com.example.superstore.model.TimeSlot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration> findByTimeSlot(TimeSlot timeSlot);
}