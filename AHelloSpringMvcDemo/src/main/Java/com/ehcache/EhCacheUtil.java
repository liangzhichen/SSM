package com.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.net.URL;

/**
 * Created by Administrator on 2018/1/10.
 */
public class EhCacheUtil {
    private static final String path = "/ehcache-setting.xml";

    private URL url;

    private CacheManager manager;

    private static EhCacheUtil ehCacheUtil;

    private EhCacheUtil(String path) {
        url = getClass().getResource(path);
        manager = CacheManager.create(url);
    }

    public static EhCacheUtil getInstance(){
        if (ehCacheUtil == null){
            ehCacheUtil = new EhCacheUtil(path);
        }
        return ehCacheUtil;
    }

    public void put(String cacheName, String key, Object value) {
        Cache cache = manager.getCache(cacheName);
        Element element = new Element(key, value);
        cache.put(element);
    }

    public Object get(String cacheName, String key) {
        Cache cache = manager.getCache(cacheName);
        Element element = cache.get(key);
        return element == null ? null : element.getObjectValue();
    }

    public Cache get(String cacheName) {
        return manager.getCache(cacheName);
    }

    public void remove(String cacheName, String key) {
        Cache cache = manager.getCache(cacheName);
        cache.remove(key);
    }
}
