package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {
        Integer[] intArray = {13, 8, 15, 5, 17};
        System.out.println(Arrays.toString(sort(intArray)));
    }

    public static Integer[] sort(Integer[] array) {
        int med;

        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        if (array.length % 2 == 0) {
            med = (array[array.length/2] + array[array.length/2-1])/2;
            System.out.println(med);
        }
        else {
            med = array[Math.round(array.length) / 2];
            System.out.println(med);
        }

        Arrays.sort(array, Comparator.comparingInt(x -> Math.abs(med - x)));
        //implement logic here
        return array;
    }
}
