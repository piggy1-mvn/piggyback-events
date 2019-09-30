package com.incentives.piggyback.events.entity;

import java.util.List;

import com.incentives.piggyback.events.dto.EventEntity;

import lombok.Data;

@Data
public class EventResponse {

	private List<EventEntity> eventEntity;
}