package com.incentives.piggyback.events.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.incentives.piggyback.events.entity.EventResponse;
import com.incentives.piggyback.events.service.EventService;

@RestController
@RequestMapping("/events")
public class EventsController {

	@Autowired
	private EventService eventService;

	@GetMapping
	public EventResponse getEvent(
			@RequestParam(name ="eventType", required = false) String eventType,
			@RequestParam(name="partnerId", required = false) String partnerId) {
		return eventService.getEvents(eventType,partnerId, Calendar.getInstance().getTime());
	}
}