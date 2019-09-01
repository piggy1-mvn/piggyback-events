package com.incentives.piggyback.events.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventsController {

    @RequestMapping("/events")
    @GetMapping
    public String home() {
        return "Hello World on Docker from EventsController";
    }

}