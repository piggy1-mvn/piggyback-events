package com.incentives.piggyback.events.repository;

import com.incentives.piggyback.events.dto.EventEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EventRepository extends MongoRepository<EventEntity, String>, EventRepositoryCustom {

}