package com.acme.doktoric;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.07.26.
 * Time: 20:44
 * To change this template use File | Settings | File Templates.
 */
public class GemfireSample {


    public static void main(String arg[]) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/app-context.xml");
        GemfireSample gemfireSample = new GemfireSample();
        gemfireSample.getNameForId();
    }

    public void getNameForId() {
        CacheSample cacheSample = new CacheSample();
        for (int i = 0; i < 20; i++) {
            cacheSample.getID("1");
        }
    }

}
