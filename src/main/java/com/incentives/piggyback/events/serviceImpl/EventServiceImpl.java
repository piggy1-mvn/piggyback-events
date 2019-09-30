package com.incentives.piggyback.events.serviceImpl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incentives.piggyback.events.adapter.ObjectAdapter;
import com.incentives.piggyback.events.entity.Event;
import com.incentives.piggyback.events.entity.EventResponse;
import com.incentives.piggyback.events.exception.ExceptionResponseCode;
import com.incentives.piggyback.events.exception.PiggyException;
import com.incentives.piggyback.events.repository.EventRepository;
import com.incentives.piggyback.events.service.EventService;
import com.incentives.piggyback.events.utils.CommonUtility;

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

	@Override
	public EventResponse getEvents(String eventType, String partnerId, Date fromDate) {
		EventResponse eventResponse = new EventResponse();
		if (CommonUtility.isValidString(eventType) && CommonUtility.isValidString(partnerId) &&(null!=fromDate)) {
			Date toDate = DateUtils.addMinutes(fromDate, -5);
			eventResponse.setEventEntity(eventRepository.getEventsByEventAllFilters(eventType,partnerId,fromDate,toDate));
		} else if(null!=fromDate){
			Date toDate = DateUtils.addMinutes(fromDate, -5);
			eventResponse.setEventEntity(eventRepository.getEventsByTimeStamp(fromDate,toDate));
		}
		return eventResponse;
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