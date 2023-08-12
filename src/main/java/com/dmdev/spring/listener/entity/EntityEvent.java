package com.dmdev.spring.listener.entity;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;
import java.util.EventObject;

public class EntityEvent extends ApplicationEvent {

    @Getter
    private final AccessType accessType;

    public EntityEvent(Object entity, AccessType accessType) {
        super(entity);
        this.accessType = accessType;
    }

}
