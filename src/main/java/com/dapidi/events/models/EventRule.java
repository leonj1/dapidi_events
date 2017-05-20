package com.dapidi.events.models;

import java.util.List;

/**
 * Created for K and M Consulting LLC.
 * Created by Jose M Leon 2017
 **/
public class EventRule implements Rule {

    private EventPattern eventPattern;
    private List<Subscriber> subscribers;

    public EventRule(EventPattern eventPattern, List<Subscriber> subscribers) {
        this.eventPattern = eventPattern;
        this.subscribers = subscribers;
    }
}
