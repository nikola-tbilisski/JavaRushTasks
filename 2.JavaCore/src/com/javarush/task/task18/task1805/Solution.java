package com.javarush.task.task18.task1805;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        BufferedInputStream readFile = new BufferedInputStream(new FileInputStream(filePath));
        Set<Integer> intSet = new TreeSet<>();

        while (readFile.available() > 0){
            intSet.addAll(Collections.singleton(readFile.read()));
        }

        readFile.close();
        //Collections.sort(intSet);
        for(Integer i : intSet)
            System.out.printf("%d ",i);

        //int[] arr = new int[readFile.available()];
        //System.out.println(readFile.available());

       /* for(int i = 0; i < arr.length; i++){
            arr[i] = readFile.read();
            //System.out.println(arr[i]);
        }*/

       // Arrays.sort(arr);

       // for (int j : arr) System.out.print(j + " ");

    }

}
