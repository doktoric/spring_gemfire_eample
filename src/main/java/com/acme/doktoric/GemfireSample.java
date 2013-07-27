package com.acme.doktoric;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.07.26.
 * Time: 20:44
 * To change this template use File | Settings | File Templates.
 */
@Component
public class GemfireSample {

    @Autowired
    public CacheSample cacheSample;

    public GemfireSample(){

    }

    public void getNameForId() {
        for (int i = 0; i < 20; i++) {
            System.out.println(i+": "+cacheSample.getID("1").toString());
        }
    }

}
