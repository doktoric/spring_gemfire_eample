package com.acme.doktoric;

import com.gemstone.gemfire.cache.*;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.ReplicatedRegionFactoryBean;
import org.springframework.data.gemfire.support.GemfireCacheManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.07.27.
 * Time: 22:21
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableCaching
@EnableWebMvc
public class CacheConfig {

    public Region region() throws Exception {
        ReplicatedRegionFactoryBean regionFactoryBean = new ReplicatedRegionFactoryBean();
        regionFactoryBean.setName("sample_cache");
        regionFactoryBean.setCacheListeners(new CacheListener[]{cacheLogger()});
      //  regionFactoryBean.setCache(cacheFactoryBean());
        return regionFactoryBean.getObject();
    }


    public Cache cache() throws Exception {
        CacheFactory cacheFactory = new CacheFactory();
        cacheFactory.set("log-level","warning");
        cacheFactory.set("name","SpringGemFireSample");
        Cache cache=  cacheFactory.create();
        return cache;
    }

    public Properties props() {
        Properties properties = new Properties();
        properties.setProperty("log-level","warning");
        properties.setProperty("name","SpringGemFireSample");
        return properties;
    }

    @Bean(name = "cacheManager")
    public GemfireCacheManager cacheManager() throws Exception {
        GemfireCacheManager cacheManager = new GemfireCacheManager();

        Cache cache = cache();
        Region<Object, Object> sample_cache = cache.createRegionFactory(RegionShortcut.LOCAL).create("sample_cache");
        Set<Region<?,?>> cacheSet = new HashSet<Region<?,?>>();
        //Region region = region();
        cacheSet.add(sample_cache);
        cacheManager.setRegions(cacheSet);
        return cacheManager;
    }

    public CacheListenerAdapter<Object, Object> cacheLogger() {
        return new CacheLogger();
    }
}
