package com.example.superstore.service;

import com.example.superstore.model.Event;
import com.example.superstore.model.Store;
import com.example.superstore.repository.EventRepository;
import com.example.superstore.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final StoreRepository storeRepository;

    public EventService(EventRepository eventRepository, StoreRepository storeRepository) {
        this.eventRepository = eventRepository;
        this.storeRepository = storeRepository;
    }

    public Event createEvent(Event event, String storeCode) {
        Store store = storeRepository.findByCode(storeCode);
        if (store == null) {
            throw new IllegalArgumentException("Store not found with code: " + storeCode);
        }
        event.setStore(store);
        return eventRepository.save(event);
    }

    public List<Event> getEventsByStore(String storeCode) {
        Store store = storeRepository.findByCode(storeCode);
        if (store == null) {
            throw new IllegalArgumentException("Store not found with code: " + storeCode);
        }
        return eventRepository.findByStore(store);
    }
}