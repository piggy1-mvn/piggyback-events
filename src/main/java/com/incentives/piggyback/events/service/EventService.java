package com.incentives.piggyback.events.service;

import java.util.Date;

import com.incentives.piggyback.events.entity.EventResponse;
import com.incentives.piggyback.events.exception.PiggyException;

public interface EventService {

    String saveEventDetails(String event) throws PiggyException;

    EventResponse getEvents(String eventType, String partnerId, Date timestamp);
}