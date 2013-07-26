package com.acme.doktoric;

import org.springframework.cache.annotation.Cacheable;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.07.26.
 * Time: 20:45
 * To change this template use File | Settings | File Templates.
 */
public class CacheSample {

    @Cacheable(value = "names", key = "#id")
    public String getID(String id) {
        if (id.equals("1")) {
            return "Attila";
        } else if (id.equals("2")) {
            return "Bela";
        } else if (id.equals("3")) {
            return "Cecil";
        } else if (id.equals("4")) {
            return "Feri";
        } else if (id.equals("5")) {
            return "Jozsi";
        } else if (id.equals("6")) {
            return "Kalman";
        } else if (id.equals("7")) {
            return "Mari";
        }
        return "Zoli";
    }

}
