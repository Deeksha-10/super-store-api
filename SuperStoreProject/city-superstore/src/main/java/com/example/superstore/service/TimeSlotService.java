package com.example.superstore.service;

import com.example.superstore.model.Event;
import com.example.superstore.model.TimeSlot;
import com.example.superstore.repository.EventRepository;
import com.example.superstore.repository.TimeSlotRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class TimeSlotService {
    private final TimeSlotRepository timeSlotRepository;
    private final EventRepository eventRepository;

    public TimeSlotService(TimeSlotRepository timeSlotRepository, EventRepository eventRepository) {
        this.timeSlotRepository = timeSlotRepository;
        this.eventRepository = eventRepository;
    }

    public TimeSlot createTimeSlot(TimeSlot timeSlot, Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found with id: " + eventId));
        timeSlot.setEvent(event);
        return timeSlotRepository.save(timeSlot);
    }

    public List<TimeSlot> getTimeSlotsByEvent(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found with id: " + eventId));
        return timeSlotRepository.findByEvent(event);
    }
}