package com.example.superstore.service;

import com.example.superstore.model.Registration;
import com.example.superstore.model.TimeSlot;
import com.example.superstore.repository.RegistrationRepository;
import com.example.superstore.repository.TimeSlotRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {
    private final RegistrationRepository registrationRepository;
    private final TimeSlotRepository timeSlotRepository;
    private final EmailService emailService;

    public RegistrationService(RegistrationRepository registrationRepository, 
                              TimeSlotRepository timeSlotRepository,
                              EmailService emailService) {
        this.registrationRepository = registrationRepository;
        this.timeSlotRepository = timeSlotRepository;
        this.emailService = emailService;
    }

    @Transactional
    public Registration registerParticipant(Registration registration, Long timeSlotId) {
        TimeSlot timeSlot = timeSlotRepository.findById(timeSlotId)
                .orElseThrow(() -> new IllegalArgumentException("Time slot not found with id: " + timeSlotId));
        
        int currentParticipants = timeSlotRepository.countRegistrationsByTimeSlotId(timeSlotId);
        if (currentParticipants >= timeSlot.getMaxCapacity()) {
            throw new IllegalStateException("Time slot is already full");
        }
        
        registration.setTimeSlot(timeSlot);
        Registration savedRegistration = registrationRepository.save(registration);
        
        // Send confirmation email
        emailService.sendConfirmationEmail(
                savedRegistration.getEmail(),
                savedRegistration.getParticipantName(),
                timeSlot.getEvent().getName(),
                timeSlot.getTime()
        );
        
        return savedRegistration;
    }
}