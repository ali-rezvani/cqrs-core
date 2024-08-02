package com.techbank.cqrs.core.commands;

import com.techbank.cqrs.core.messages.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseCommand extends Message {
    public BaseCommand(UUID id) {
        super(id);
    }
}
