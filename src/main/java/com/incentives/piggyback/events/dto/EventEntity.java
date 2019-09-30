package com.incentives.piggyback.events.dto;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "event")
public class EventEntity {
    private String eventId;
    private String eventType;
    private Date timeStamp;
    private String partnerId;
    private String sourceId;

}