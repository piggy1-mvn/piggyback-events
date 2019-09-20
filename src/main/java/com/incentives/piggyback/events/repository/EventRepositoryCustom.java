package com.incentives.piggyback.events.repository;


import com.incentives.piggyback.events.dto.EventEntity;

import java.util.Date;
import java.util.List;

public interface EventRepositoryCustom {

    List<EventEntity> getEventsByEventPartnerType(String eventType, String PartnerId);

    List<EventEntity> getEventsByEventType(String eventType);

    List<EventEntity> getEventsByPartnerType(String PartnerId);

    List<EventEntity> getEventsByEventAllFilters(String eventType, String PartnerId, Date fromDate, Date toDate);

    List<EventEntity> getEventsByTimeStamp(Date fromDate, Date toDate);
    
}
