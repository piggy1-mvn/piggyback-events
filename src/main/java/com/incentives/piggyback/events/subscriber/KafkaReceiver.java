package com.incentives.piggyback.events.subscriber;

import com.incentives.piggyback.events.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaReceiver {

    @Autowired
    private EventService eventService;

    private static final Logger LOG = LoggerFactory.getLogger(KafkaReceiver.class);

    @KafkaListener(topics = {"locationEvents" , "offerEvents", "userEvents", "partnerEvents", "notificationEvents", "orderEvents"})
    public void listen(@Payload String message) {
        LOG.info("received message='{}'", message);
        eventService.saveEventDetails(message);
    }

}