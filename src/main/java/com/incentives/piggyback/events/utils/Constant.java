package com.incentives.piggyback.events.utils;

public interface Constant {
	Integer SUCCESS_STATUS = 200;
	Integer FAILURE_STATUS = 101;
	
	String EVENT_SERVICE_LOCATION_SUBSCRIBER = "location.subscriber.topic";
	String EVENT_SERVICE_USER_SUBSCRIBER = "user.subscriber.topic";
	String EVENT_SERVICE_PARTNER_SUBSCRIBER = "partner.subscriber.topic";
	String EVENT_SERVICE_OFFERS_SUBSCRIBER = "offer.subscriber.topic";
	String EVENT_SERVICE_NOTIFICATION_SUBSCRIBER = "notification.subscriber.topic";

	String LOCATION_PUBLISHER_TOPIC = "location.publisher.topic";
	String USER_PUBLISHER_TOPIC = "user.publisher.topic";
	String PARTNER_PUBLISHER_TOPIC = "partner.publisher.topic";
	String OFFERS_PUBLISHER_TOPIC = "offer.publisher.topic";
	String NOTIFICATION_PUBLISHER_TOPIC = "notification.publisher.topic";
}