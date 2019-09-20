package com.incentives.piggyback.events.service;

import com.incentives.piggyback.events.dto.EventEntity;
import com.incentives.piggyback.events.exception.PiggyException;

import java.util.Date;
import java.util.List;

public interface EventService {

    String saveEventDetails(String event) throws PiggyException;

    List<EventEntity> getEvents(String eventType, String partnerId, Date timestamp);
}