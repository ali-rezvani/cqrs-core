package com.techbank.cqrs.core.messages;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class Message{
    private UUID id;
}
