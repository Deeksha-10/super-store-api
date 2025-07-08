
package com.example.superstore.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events/{eventId}/timeslots")
public class TimeSlotController {

    @PostMapping
    public String createTimeSlot(@PathVariable Long eventId) {
        return "Time slot created for event " + eventId;
    }
}
