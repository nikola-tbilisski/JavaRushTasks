package com.javarush.task.task35.task3509;

import java.util.*;

/* 
Collections & Generics
*/

public class Solution {

    public static void main(String[] args) {
        List<Integer> intList = newArrayList(2, 5, 4, 6);
        System.out.println("newArrayList intList " + intList);

        List<String> stringList = newArrayList("vaso", "beso", "keso");
        System.out.println("newArrayList stringList " + stringList);

        Set<Integer> intSet = newHashSet(7, 23, 5, 9, 45, 1, 32);
        System.out.println("newHashSet intSet " + intSet);

        Set<String> strSet = newHashSet("vova", "bora", "gora", "agora");
        System.out.println("newHashSet strSet " + strSet);

        Set<Integer> intTreeSet = newTreeSet(7, 23, 5, 9, 45, 1, 32);
        System.out.println("newTreeSet intTreeSet " + intTreeSet);

        Set<String> strTreeSet = newTreeSet("vova", "bora", "gora", "agora");
        System.out.println("newTreeSet strTreeSet " + strTreeSet);

        HashMap<Object, Number> map =
                newHashMap(newArrayList("koran", "zohan", "xuioxan"), newArrayList(1, 2, 3));
        System.out.println("newHashMap " + map);
    }

    @SafeVarargs
    public static <T> ArrayList<T> newArrayList(T... elements) {
        //напишите тут ваш код
        return new ArrayList<>(Arrays.asList(elements));
    }

    @SafeVarargs
    public static <T> HashSet<T> newHashSet(T... elements) {
        //напишите тут ваш код
        return new HashSet<>(Arrays.asList(elements));
    }

    @SafeVarargs
    public static <T> TreeSet<T> newTreeSet(T... elements) {
        //напишите тут ваш код
        return new TreeSet<>(Arrays.asList(elements));
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        if (keys.size() != values.size()) throw new IllegalArgumentException();
        HashMap<K, V> kvHashMap = new HashMap<>();

        for (int i = 0; i < keys.size(); i++) {
            kvHashMap.put(keys.get(i), values.get(i));
        }
        //напишите тут ваш код
        return kvHashMap;
    }
}
