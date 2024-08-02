package com.techbank.cqrs.core.events;

import com.techbank.cqrs.core.messages.Message;


public class BaseEvent extends Message {
    private int version;

}
