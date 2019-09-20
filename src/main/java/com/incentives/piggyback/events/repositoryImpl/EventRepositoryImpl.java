package com.incentives.piggyback.events.repositoryImpl;

import com.incentives.piggyback.events.dto.EventEntity;
import com.incentives.piggyback.events.repository.EventRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class EventRepositoryImpl implements EventRepositoryCustom {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public EventRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<EventEntity> getEventsByEventPartnerType(String eventType, String PartnerId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("eventType").is(eventType).and("partnerId").is(PartnerId));
        List<EventEntity> events = mongoTemplate.find(query, EventEntity.class);
        return events;
    }
    @Override
    public List<EventEntity> getEventsByEventType(String eventType) {
        Query query = new Query();
        query.addCriteria(Criteria.where("eventType").is(eventType));
        List<EventEntity> events = mongoTemplate.find(query, EventEntity.class);
        return events;
    }

    @Override
    public List<EventEntity> getEventsByPartnerType(String PartnerId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("partnerId").is(PartnerId));
        List<EventEntity> events = mongoTemplate.find(query, EventEntity.class);
        return events;
    }

    @Override
    public List<EventEntity> getEventsByEventAllFilters(String eventType, String PartnerId, Date fromDate, Date toDate) {
        Query query = new Query();
        query.addCriteria(Criteria.where("eventType").is(eventType).and("partnerId").is(PartnerId).and("timeStamp").lte(fromDate).gte(toDate));
        List<EventEntity> events = mongoTemplate.find(query, EventEntity.class);
        return events;
    }

    @Override
    public List<EventEntity> getEventsByTimeStamp(Date fromDate, Date toDate) {
        Query query = new Query();
        query.addCriteria(Criteria.where("timeStamp").lte(fromDate).gte(toDate));
        List<EventEntity> events = mongoTemplate.find(query, EventEntity.class);
        return events;
    }


}
