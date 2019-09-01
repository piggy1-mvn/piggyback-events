package com.incentives.piggyback.events.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "event")
public class EventEntity {
    @JsonIgnore
    @Id
    private String eventId;
    private String eventType;
    private Date timeStamp;
    private String partnerId;
    private String sourceId;

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

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
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

/*    @Override
    public String toString() {
        return "LocationEntity [locationId=" + locationId + ", userId=" + userId + ", latitude=" + latitude
                + ", longitude=" + longitude + ", gpsAccuracy=" + gpsAccuracy + ", deviceId=" + deviceId
                + ", createdDate=" + createdDate + ", lastModifiedDate=" + lastModifiedDate + "]";
    }*/

}