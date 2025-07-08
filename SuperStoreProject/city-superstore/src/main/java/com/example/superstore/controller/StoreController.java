
package com.example.superstore.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @PostMapping
    public String createStore() {
        return "Store created successfully";
    }
}
