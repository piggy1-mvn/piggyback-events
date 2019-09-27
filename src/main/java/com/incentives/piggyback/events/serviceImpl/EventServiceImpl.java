package com.incentives.piggyback.events.serviceImpl;

import com.incentives.piggyback.events.dto.EventEntity;
import com.incentives.piggyback.events.service.EventService;
import com.incentives.piggyback.events.adapter.ObjectAdapter;
import com.incentives.piggyback.events.entity.Event;
import com.incentives.piggyback.events.exception.ExceptionResponseCode;
import com.incentives.piggyback.events.exception.PiggyException;
import com.incentives.piggyback.events.repository.EventRepository;
import com.incentives.piggyback.events.utils.CommonUtility;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
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

	@Override
	public List<EventEntity> getEvents(String eventType, String partnerId, Date fromDate) {
		if (CommonUtility.isValidString(eventType) && CommonUtility.isValidString(partnerId) &&(null!=fromDate)) {
			Date toDate = DateUtils.addMonths(fromDate, -1);
			return eventRepository.getEventsByEventAllFilters(eventType,partnerId,fromDate,toDate);
		} else if(CommonUtility.isValidString(eventType) && CommonUtility.isValidString(partnerId) ){
			return eventRepository.getEventsByEventPartnerType(eventType,partnerId);
		} else if(CommonUtility.isValidString(eventType)){
			return eventRepository.getEventsByEventType(eventType);
		}else if(CommonUtility.isValidString(partnerId)){
			return eventRepository.getEventsByPartnerType(partnerId);
		}else if(null!=fromDate){
			Date toDate = DateUtils.addMonths(fromDate, -1);
			return eventRepository.getEventsByTimeStamp(fromDate,toDate);
		}
			return eventRepository.findAll();

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