package com.incentives.piggyback.events.adapter;

import java.util.Calendar;
import java.util.UUID;
import com.incentives.piggyback.events.dto.EventEntity;
import com.incentives.piggyback.events.entity.Event;

public class ObjectAdapter {

    public static EventEntity getEventEntity(Event event) {
        EventEntity eventDTO = new EventEntity();
        eventDTO.setEventId(UUID.randomUUID().toString());
        eventDTO.setEventType(event.getEventType());
        eventDTO.setTimeStamp(Calendar.getInstance().getTime());
        eventDTO.setPartnerId(event.getPartnerId());
        eventDTO.setSourceId(event.getSourceId());
        return eventDTO;
    }

}