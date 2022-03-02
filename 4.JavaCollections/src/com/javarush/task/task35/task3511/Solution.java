package com.javarush.task.task35.task3511;

import java.util.*;

/* 
Wildcards для коллекций
*/

public class Solution {

    public static void main(String[] args) {
        List<Integer> integerList = new LinkedList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
       // System.out.println(integerList);

        List<Double> doubleList = new LinkedList<>();
        doubleList.add(2.2);
        doubleList.add(2.3);
        doubleList.add(2.4);
        doubleList.add(2.5);
        doubleList.add(2.6);

    }

    public static Double sum(List<? extends Number> list) {
        Double result = 0.0;
        for (int i = 0; i < list.size(); i++) {
            Number numb = (Number) list.get(i);
            result += numb.doubleValue();
        }
        return result;
    }

    public static Double multiply(List<? extends Number> list) {
        Double result = 1.0;
        for (int i = 0; i < list.size(); i++) {
            Number numb = (Number) list.get(i);
            result *= numb.doubleValue();
        }
        return result;
    }

    public static String concat(List<?> list) {
        StringBuilder builder = new StringBuilder();
        for (Object obj : list) {
            builder.append(obj);
        }
        return builder.toString();
    }

    public static List combine(List<? extends Collection> list) {
        List result = new ArrayList<>();
        for (Collection collection : list) {
            result.addAll(collection);
        }
        return result;
    }
}
