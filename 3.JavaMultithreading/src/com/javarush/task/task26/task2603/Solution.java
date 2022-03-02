package com.javarush.task.task26.task2603;

import javax.swing.plaf.nimbus.State;
import java.util.*;
import java.util.stream.Stream;

/* 
Убежденному убеждать других не трудно
*/

public class Solution {

    public static void main(String[] args) {
        List<People> people = new ArrayList<>();
        people.add(new People("Johny", "Dillinger", 184, 80));
        people.add(new People("Tom", "Glancy", 194, 94));
        people.add(new People("Robert", "Downy", 176, 57));
        people.add(new People("Johny", "Mcmannaman", 187, 80));
        people.add(new People("Niel", "Glancy", 187, 94));

        Collections.sort(people, new CustomizedComparator<>(Comparator.comparing(o -> o.name), Comparator.comparing(o -> o.surname)));

        for (People p : people) {
            System.out.println(p);
        }

    }

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        @SafeVarargs
        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2) {
            int result = 0;

            for(Comparator comparator : comparators) {
                result = comparator.compare(o1, o2);
                if(result != 0) break;
            }
            return result;

//            @Override //option with stream+lambda
//            public int compare(T o1, T o2) {
//                return Arrays.stream(comparators)
//                        .flatMap(comparator -> Stream.of(comparator.compare(o1,o2)))
//                        .filter( num -> num != 0)
//                        .findFirst()
//                        .orElse(0);
//            }
        }
    }
}
