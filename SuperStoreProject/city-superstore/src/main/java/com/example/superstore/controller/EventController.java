
package com.example.superstore.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {

	@PostMapping
	public String createEvent() {
		return "Event created successfully";
	}
}
