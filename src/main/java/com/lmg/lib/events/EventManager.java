package com.lmg.lib.events;


public interface EventManager {
    
    public void subscribe(EventListener listener);

    public void unsubscribe(EventListener listener);

    public void notifySubscribers(Object obj);
}
