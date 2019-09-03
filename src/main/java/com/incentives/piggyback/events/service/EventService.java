package com.incentives.piggyback.events.service;

import com.incentives.piggyback.events.exception.PiggyException;

public interface EventService {

    String saveEventDetails(String event) throws PiggyException;
}