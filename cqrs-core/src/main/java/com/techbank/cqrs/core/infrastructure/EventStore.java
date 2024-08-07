package com.techbank.cqrs.core.infrastructure;

import com.techbank.cqrs.core.events.BaseEvent;

import java.util.List;
import java.util.UUID;

public interface EventStore {
    void saveEvents(UUID aggregateId, Iterable<BaseEvent> events, int expectedVersion);
    List<BaseEvent> getEvents(UUID aggregateId);
}
