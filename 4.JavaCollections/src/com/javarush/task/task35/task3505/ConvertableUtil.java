package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    // my first method option
//    public static Map convert(List<? extends Convertable<?>> list) {
//        Map result = new HashMap();
//
////        for(int i = 0; i < list.size(); i++){
////            result.put(list.get(i).getKey(), list.get(i));
////        }
//
//        for (Convertable<?> convertable : list) {
//            result.put(convertable.getKey(), convertable);
//        }
//
//        if(result.size() != list.size()) throw new IllegalArgumentException();
//
//        return result;
//    }

    // second refactored option
    public static <K, V extends Convertable<K>> Map<K, V> convert(List<V> list){
        Map<K, V> result = new HashMap<>();

        for (V v : list) {
            result.put(v.getKey(), v);
        }

        if(result.size() != list.size()) throw new IllegalArgumentException();

        return result;
    }
}
