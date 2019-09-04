package com.incentives.piggyback.events.serviceImpl;

import com.incentives.piggyback.events.service.EventService;
import com.incentives.piggyback.events.adapter.ObjectAdapter;
import com.incentives.piggyback.events.entity.Event;
import com.incentives.piggyback.events.exception.ExceptionResponseCode;
import com.incentives.piggyback.events.exception.PiggyException;
import com.incentives.piggyback.events.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	private EventRepository eventRepository;

	@Override
	public String saveEventDetails(String eventString) {
		Event event = validateAndConstructEventFromEventString(eventString);
		eventRepository.save(ObjectAdapter.getEventEntity(event));
		return "Event saved successfully!";
	}

	private Event validateAndConstructEventFromEventString(String eventString) {
		try {
			List<String> eventList = Arrays.asList(eventString.split(";"));
			return new Event(eventList.get(0), eventList.get(1), eventList.get(2), eventList.get(3), eventList.get(4));
		} catch (Exception e) {
			throw new PiggyException(ExceptionResponseCode.USER_DATA_NOT_FOUND_IN_REQUEST);
		}
	}

}