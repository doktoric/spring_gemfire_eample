package com.acme.doktoric;

import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

public class CacheLogger extends CacheListenerAdapter<Object, Object> {


    @Override
    public void afterCreate(EntryEvent<Object, Object> event) {
        System.out.println("Added " + messageLog(event) + " to the cache");
    }

    @Override
    public void afterDestroy(EntryEvent<Object, Object> event) {
        System.out.println("Removed " + messageLog(event) + " from the cache");
    }

    @Override
    public void afterUpdate(EntryEvent<Object, Object> event) {
        System.out.println("Updated " + messageLog(event) + " in the cache");
    }

    private String messageLog(EntryEvent<Object, Object> event) {
        Object key = event.getKey();
        Object value = event.getNewValue();

        if (event.getOperation().isUpdate()) {
            return "[" + key + "] from [" + event.getOldValue() + "] to [" + event.getNewValue() + "]";
        }
        return "[" + key + "=" + value + "]";
    }
}