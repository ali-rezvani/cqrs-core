package com.techbank.cqrs.core.handler;

import com.techbank.cqrs.core.domain.AggregateRoot;

import java.util.UUID;

public interface EventSourcingHandler<T> {
    void save(AggregateRoot aggregate);
    T getById(UUID id);
}
