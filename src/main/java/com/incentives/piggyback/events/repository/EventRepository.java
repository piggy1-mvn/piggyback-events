package com.incentives.piggyback.events.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.incentives.piggyback.events.dto.EventEntity;

public interface EventRepository extends MongoRepository<EventEntity, String>, EventRepositoryCustom {

}