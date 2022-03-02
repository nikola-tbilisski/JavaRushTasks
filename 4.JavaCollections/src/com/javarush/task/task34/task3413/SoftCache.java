package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        //if(!cacheMap.containsKey(key)) return null;
        SoftReference<AnyObject> softReference = cacheMap.get(key);

        return (softReference == null) ? null : softReference.get();
        //return (cacheMap.containsKey(key)) ? softReference.get() : null;
        //напишите тут ваш код
    }

    public AnyObject put(Long key, AnyObject value) {
//        for(Map.Entry<Long, SoftReference<AnyObject>> entry : cacheMap.entrySet()){
//        }

        SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));

        if(softReference != null){
            AnyObject anyObject = softReference.get();
            softReference.clear();
            return anyObject;
        }

        return null;
        //напишите тут ваш код
    }

    public AnyObject remove(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.remove(key);

        if(softReference != null){
            AnyObject anyObject = softReference.get();
            softReference.clear();
            return anyObject;
        }

        return null;
        //напишите тут ваш код
    }
}