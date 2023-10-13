package com.lmg.lib.events;

import java.util.ArrayList;
import java.util.List;

public class EventManagerImpl implements EventManager {

    public List<EventListener> listeners = new ArrayList<EventListener>();

    public EventManagerImpl() { }

    @Override
    public void subscribe(EventListener listener) {
        listeners.add(listener);
    }

    @Override
    public void unsubscribe(EventListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void notifySubscribers(Object obj) {
        for (EventListener listener : listeners) {
            listener.update(obj);
        }
    }
    
    
}
