package com.incentives.piggyback.events.entity;

import org.springframework.hateoas.ResourceSupport;

public class Event extends ResourceSupport {

    private String eventId;
    private String eventType;
    private String timeStamp;
    private String partnerId;
    private String sourceId;

    public Event() {
        
    }

    public Event(String eventId, String eventType, String timeStamp, String partnerId, String sourceId) {
        this.eventId = eventId;
        this.eventType = eventType;
        this.timeStamp = timeStamp;
        this.partnerId = partnerId;
        this.sourceId = sourceId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }
}