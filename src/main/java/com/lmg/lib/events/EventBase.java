package com.lmg.lib.events;

import java.util.ArrayList;
import java.util.List;

public abstract class EventBase {
    

    public List<EventListener> listeners = new ArrayList<EventListener>();
    public EventManager eventManager = new EventManagerImpl();

    protected EventManager getEventManager() {
        return eventManager;
    }

    protected void fireEvent(Object obj) {
        eventManager.notifySubscribers(obj);
    }

    public void subscribe(EventListener listener) {
        eventManager.subscribe(listener);
    }


    
}
