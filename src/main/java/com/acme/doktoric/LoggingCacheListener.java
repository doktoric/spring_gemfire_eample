package com.acme.doktoric;

import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;
import org.springframework.stereotype.Component;

@Component
public class LoggingCacheListener extends CacheListenerAdapter {


    @Override
    public void afterCreate(EntryEvent event) {
        final String regionName = event.getRegion().getName();
        final Object key = event.getKey();
        final Object newValue = event.getNewValue();
        System.out.println("In region [" + regionName + "] created key [" + key
                + "] value [" + newValue + "]");
    }

    @Override
    public void afterDestroy(EntryEvent event) {
        final String regionName = event.getRegion().getName();
        final Object key = event.getKey();
        System.out.println("In region [" + regionName + "] destroyed key [" + key
                + "]");
    }

    @Override
    public void afterUpdate(EntryEvent event) {
        final String regionName = event.getRegion().getName();
        final Object key = event.getKey();
        final Object newValue = event.getNewValue();
        final Object oldValue = event.getOldValue();
        System.out.println("In region [" + regionName + "] updated key [" + key
                + "] [oldValue [" + oldValue + "] new value [" + newValue +"]");
    }
}
