package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        if(!cache.containsKey(key)) {
     //       Constructor<V> constr = clazz.getConstructor(key.getClass());
            V ob = clazz.getConstructor(key.getClass()).newInstance(key);
            cache.put(key, ob);
        }

        return cache.get(key);
        //TODO add your code here
    }

    public boolean put(V obj) {
        try {
            Method getKeyMethod = obj.getClass().getDeclaredMethod("getKey");
            getKeyMethod.setAccessible(true);
           // K key = (K) getKeyMethod.invoke(obj);
            cache.put((K) (getKeyMethod.invoke(obj)), obj);
            return true;

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ignored) {}

        //TODO add your code here
        return false;
    }

    public int size() {
        return cache.size();
    }
}
