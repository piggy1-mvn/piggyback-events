package com.incentives.piggyback.events.utils;

public interface Constant {
	Integer SUCCESS_STATUS = 200;
	Integer FAILURE_STATUS = 101;
	
	String EVENT_SERVICE_LOCATION_SUBSCRIBER = "location.subscriber.topic";
	String EVENT_SERVICE_USER_SUBSCRIBER = "user.subscriber.topic";
	String EVENT_SERVICE_PARTNER_SUBSCRIBER = "partner.subscriber.topic";
	String EVENT_SERVICE_OFFERS_SUBSCRIBER = "offer.subscriber.topic";
	String EVENT_SERVICE_NOTIFICATION_SUBSCRIBER = "notification.subscriber.topic";
}