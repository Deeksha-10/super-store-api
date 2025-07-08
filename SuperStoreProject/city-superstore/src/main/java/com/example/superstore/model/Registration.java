package com.example.superstore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "registrations")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String participantName;
    
    @Column(nullable = false)
    private String email;
    
    @ManyToOne
    @JoinColumn(name = "timeslot_id", nullable = false)
    private TimeSlot timeSlot;

	public void setTimeSlot(TimeSlot timeSlot2) {
		// TODO Auto-generated method stub
		
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getParticipantName() {
		// TODO Auto-generated method stub
		return null;
	}
}