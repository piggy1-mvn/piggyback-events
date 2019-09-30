package com.incentives.piggyback.events.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Data
@Document(collection = "event")
public class EventEntity {
    @JsonIgnore
    @Id
    private String eventId;
    private String eventType;

    private Date timeStamp;

    private String partnerId;
    private String sourceId;

}