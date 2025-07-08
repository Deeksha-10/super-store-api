package com.example.superstore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "timeslots")
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private LocalTime time;
    
    @Column(nullable = false)
    private int maxCapacity = 20;
    
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
    
    @Transient
    private int currentParticipants;

	public int getMaxCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setEvent(Event event2) {
		// TODO Auto-generated method stub
		
	}

	public Event getEvent() {
		// TODO Auto-generated method stub
		return null;
	}

	public LocalTime getTime() {
		// TODO Auto-generated method stub
		return null;
	}
}