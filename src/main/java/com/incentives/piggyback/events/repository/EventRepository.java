package com.incentives.piggyback.events.repository;

import com.incentives.piggyback.events.dto.EventEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<EventEntity, String> {

}