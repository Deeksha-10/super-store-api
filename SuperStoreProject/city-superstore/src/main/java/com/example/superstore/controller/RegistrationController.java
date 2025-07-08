
package com.example.superstore.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @PostMapping
    public String registerParticipant() {
        return "Participant registered and email sent";
    }
}
