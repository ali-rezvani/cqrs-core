package com.techbank.cqrs.core.domain;

import com.techbank.cqrs.core.events.BaseEvent;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Data
public abstract class AggregateRoot {
    @Getter
    protected UUID id;
    @Getter
    private int version=-1;
    private final List<BaseEvent> changes=new ArrayList<>();

    public List<BaseEvent> getUncommittedChanges() {
        return changes;
    }
    public void markChangesAsCommitted() {
        this.changes.clear();
    }
    protected void applyChange(BaseEvent event, Boolean isNewEvent) {
        try {
            var method = getClass().getDeclaredMethod("apply", event.getClass());
            method.setAccessible(true);
            method.invoke(this, event);
        } catch (NoSuchMethodException e) {
            log.warn(MessageFormat.format("The apply method was not found in the aggregate for {0}", event.getClass().getName()));
        } catch (Exception e) {
            log.error("Error applying event to aggregate:", e);
        } finally {
            if (isNewEvent) {
                changes.add(event);
            }
        }
    }
    public void raiseEvent(BaseEvent event) {
        applyChange(event, true);
    }

    public void replayEvents(Iterable<BaseEvent> events) {
        events.forEach(event -> applyChange(event, false));
    }
}
