package com.incentives.piggyback.events.controller;

import com.incentives.piggyback.events.dto.EventEntity;
import com.incentives.piggyback.events.service.EventService;
import com.incentives.piggyback.events.utils.RestResponse;
import com.incentives.piggyback.events.utils.RestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventsController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public ResponseEntity<List<EventEntity>> getEvent(
            @RequestParam(name ="eventType", required = false) String eventType,
            @RequestParam(name="partnerId", required = false) String partnerId,
            @RequestParam(name="timeStamp", required = false)  @DateTimeFormat(pattern="yyyy-MM-dd") Date timestamp) {

        List<EventEntity> events = eventService.getEvents(eventType,partnerId,timestamp);
        return ResponseEntity.ok(events);
    }



}