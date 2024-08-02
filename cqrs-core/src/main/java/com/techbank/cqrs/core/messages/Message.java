package com.techbank.cqrs.core.messages;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Message{
    private String id;
}
