package com.javarush.task.task24.task2410;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/* 
Рефакторинг, анонимные классы
*/

public class Solution {
    public static List<Iterator> iterators = new LinkedList<>();

    private int countItems;

    public Iterator getIterator(final String name) {
        /*Iterator iterator = new Iterator() {
            @Override
            public Iterator next() {
                return getIterator(name);
            }
            {
                countItems ++;
                System.out.println(name + " item " + countItems);
            }
        };
        return getIterator(name);*/
       /* class LocalIterator implements Iterator {
            public LocalIterator() {
                countItems++;
                System.out.println(name + " item " + countItems);
            }

            public Iterator next() {
                return new LocalIterator();
            }
        }*/
        return new Iterator() {
            @Override
            public Iterator next() {
                return getIterator(name);
            }

            {
                countItems ++;
                System.out.println(name + " item " + countItems);
            }
        };
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Iterator iterator = solution.getIterator("iterator");
        for (int i = 1; i < 5; i++) {
            iterators.add(iterator.next());
        }
    }
}
