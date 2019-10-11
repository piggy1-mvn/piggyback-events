package com.incentives.piggyback.events.utils;

public interface Constant {
	Integer SUCCESS_STATUS = 200;
	Integer FAILURE_STATUS = 101;

	String KAFKA_BOOTSTRAP_ADDRESS = "kafka.bootstrap.address";

	String EVENT_SERVICE_LOCATION_SUBSCRIBER = "location.subscriber";
	String EVENT_SERVICE_USER_SUBSCRIBER = "user.subscriber";
	String EVENT_SERVICE_PARTNER_SUBSCRIBER = "partner.subscriber";
	String EVENT_SERVICE_OFFERS_SUBSCRIBER = "offer.subscriber";
	String EVENT_SERVICE_NOTIFICATION_SUBSCRIBER = "notification.subscriber";
	String EVENT_SERVICE_ORDER_SUBSCRIBER = "order.subscriber";
}