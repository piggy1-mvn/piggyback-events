package com.incentives.piggyback.events.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@Document(collection = "event")
public class EventEntity {
    @JsonIgnore
    @Id
    private String eventId;
    private String eventType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date timeStamp;

    private String partnerId;
    private String sourceId;

}