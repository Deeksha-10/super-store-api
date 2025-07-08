package com.example.superstore.repository;

import com.example.superstore.model.Event;
import com.example.superstore.model.TimeSlot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
    List<TimeSlot> findByEvent(Event event);
    
    @Query("SELECT COUNT(r) FROM Registration r WHERE r.timeSlot.id = :timeSlotId")
    int countRegistrationsByTimeSlotId(@Param("timeSlotId") Long timeSlotId);
}