//package com.incentives.piggyback.events.subscriber;
//
//import com.google.cloud.pubsub.v1.AckReplyConsumer;
//import com.incentives.piggyback.common.pubsub.SubscriberHelper;
//import com.incentives.piggyback.events.EventsApplication;
//import com.incentives.piggyback.events.service.EventService;
//import com.incentives.piggyback.events.utils.Constant;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
//import org.springframework.cloud.gcp.pubsub.integration.AckMode;
//import org.springframework.cloud.gcp.pubsub.integration.inbound.PubSubInboundChannelAdapter;
//import org.springframework.cloud.gcp.pubsub.support.GcpPubSubHeaders;
//import org.springframework.context.annotation.Bean;
//import org.springframework.integration.annotation.ServiceActivator;
//import org.springframework.integration.channel.DirectChannel;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.MessageHandler;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//
//@Service
//public class EventSubscriber {
//
//    private static final Log LOGGER = LogFactory.getLog(EventsApplication.class);
//
//    @Autowired
//    private EventService eventService;
//
//    @Bean
//    public MessageChannel pubsubInputChannelForLocation() {
//        return new DirectChannel();
//    }
//    @Bean
//    public MessageChannel pubsubInputChannelForOffers() {
//        return new DirectChannel();
//    }
//    @Bean
//    public MessageChannel pubsubInputChannelForUser() {
//        return new DirectChannel();
//    }
//    @Bean
//    public MessageChannel pubsubInputChannelForNotification() {
//        return new DirectChannel();
//    }
//    @Bean
//    public MessageChannel pubsubInputChannelForPartner() {
//        return new DirectChannel();
//    }
//
//    @Bean
//    public PubSubInboundChannelAdapter messageChannelAdapterForLocation(
//            @Qualifier("pubsubInputChannelForLocation") MessageChannel inputChannel, PubSubTemplate pubSubTemplate) {
//
//        PubSubInboundChannelAdapter adapter =
//                new PubSubInboundChannelAdapter(pubSubTemplate, Constant.EVENT_SERVICE_LOCATION_SUBSCRIBER);
//        adapter.setOutputChannel(inputChannel);
//        adapter.setAckMode(AckMode.MANUAL);
//        return adapter;
//    }
//
//    @Bean
//    public PubSubInboundChannelAdapter messageChannelAdapterForUser(
//            @Qualifier("pubsubInputChannelForUser") MessageChannel inputChannel, PubSubTemplate pubSubTemplate) {
//
//        PubSubInboundChannelAdapter adapter =
//                new PubSubInboundChannelAdapter(pubSubTemplate, Constant.EVENT_SERVICE_USER_SUBSCRIBER);
//        adapter.setOutputChannel(inputChannel);
//        adapter.setAckMode(AckMode.MANUAL);
//        return adapter;
//    }
//
//    @Bean
//    public PubSubInboundChannelAdapter messageChannelAdapterForPartner(
//            @Qualifier("pubsubInputChannelForPartner") MessageChannel inputChannel, PubSubTemplate pubSubTemplate) {
//
//        PubSubInboundChannelAdapter adapter =
//                new PubSubInboundChannelAdapter(pubSubTemplate, Constant.EVENT_SERVICE_PARTNER_SUBSCRIBER);
//        adapter.setOutputChannel(inputChannel);
//        adapter.setAckMode(AckMode.MANUAL);
//        return adapter;
//    }
//
//    @Bean
//    public PubSubInboundChannelAdapter messageChannelAdapterForOffers(
//            @Qualifier("pubsubInputChannelForOffers") MessageChannel inputChannel, PubSubTemplate pubSubTemplate) {
//
//        PubSubInboundChannelAdapter adapter =
//                new PubSubInboundChannelAdapter(pubSubTemplate, Constant.EVENT_SERVICE_OFFERS_SUBSCRIBER);
//        adapter.setOutputChannel(inputChannel);
//        adapter.setAckMode(AckMode.MANUAL);
//        return adapter;
//    }
//
//    @Bean
//    public PubSubInboundChannelAdapter messageChannelAdapterForNotification(
//            @Qualifier("pubsubInputChannelForNotification") MessageChannel inputChannel, PubSubTemplate pubSubTemplate) {
//
//        PubSubInboundChannelAdapter adapter =
//                new PubSubInboundChannelAdapter(pubSubTemplate, Constant.EVENT_SERVICE_NOTIFICATION_SUBSCRIBER);
//        adapter.setOutputChannel(inputChannel);
//        adapter.setAckMode(AckMode.MANUAL);
//        return adapter;
//    }
//
//    @Bean
//    @ServiceActivator(inputChannel = "pubsubInputChannelForLocation")
//    public MessageHandler messageReceiverForLocation() {
//        return message -> {
//            LOGGER.info(Constant.EVENT_SERVICE_LOCATION_SUBSCRIBER + ":  Payload: " + new String((byte[]) message.getPayload()));
//            eventService.saveEventDetails(new String((byte[]) message.getPayload()));
//            AckReplyConsumer consumer =
//                    (AckReplyConsumer) message.getHeaders().get(GcpPubSubHeaders.ACKNOWLEDGEMENT);
//            consumer.ack();
//        };
//    }
//
//    @Bean
//    @ServiceActivator(inputChannel = "pubsubInputChannelForUser")
//    public MessageHandler messageReceiverForUser() {
//        return message -> {
//            LOGGER.info(Constant.EVENT_SERVICE_USER_SUBSCRIBER + ": Payload: " + new String((byte[]) message.getPayload()));
//            eventService.saveEventDetails(new String((byte[]) message.getPayload()));
//            AckReplyConsumer consumer =
//                    (AckReplyConsumer) message.getHeaders().get(GcpPubSubHeaders.ACKNOWLEDGEMENT);
//            consumer.ack();
//        };
//    }
//
//    @Bean
//    @ServiceActivator(inputChannel = "pubsubInputChannelForPartner")
//    public MessageHandler messageReceiverForPartner() {
//        return message -> {
//            LOGGER.info(Constant.EVENT_SERVICE_PARTNER_SUBSCRIBER + ": Payload: " + new String((byte[]) message.getPayload()));
//            eventService.saveEventDetails(new String((byte[]) message.getPayload()));
//            AckReplyConsumer consumer =
//                    (AckReplyConsumer) message.getHeaders().get(GcpPubSubHeaders.ACKNOWLEDGEMENT);
//            consumer.ack();
//        };
//    }
//
//    @Bean
//    @ServiceActivator(inputChannel = "pubsubInputChannelForOffers")
//    public MessageHandler messageReceiverForOffers() {
//        return message -> {
//            LOGGER.info(Constant.EVENT_SERVICE_OFFERS_SUBSCRIBER + ": Payload: " + new String((byte[]) message.getPayload()));
//            eventService.saveEventDetails(new String((byte[]) message.getPayload()));
//            AckReplyConsumer consumer =
//                    (AckReplyConsumer) message.getHeaders().get(GcpPubSubHeaders.ACKNOWLEDGEMENT);
//            consumer.ack();
//        };
//    }
//
//    @Bean
//    @ServiceActivator(inputChannel = "pubsubInputChannelForNotification")
//    public MessageHandler messageReceiverForNotification() {
//        return message -> {
//            LOGGER.info(Constant.EVENT_SERVICE_NOTIFICATION_SUBSCRIBER + ": Payload: " + new String((byte[]) message.getPayload()));
//            eventService.saveEventDetails(new String((byte[]) message.getPayload()));
//            AckReplyConsumer consumer =
//                    (AckReplyConsumer) message.getHeaders().get(GcpPubSubHeaders.ACKNOWLEDGEMENT);
//            consumer.ack();
//        };
//    }
//
//}