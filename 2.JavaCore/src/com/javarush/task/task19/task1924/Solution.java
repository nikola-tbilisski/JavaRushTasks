package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        String lines;
        long start = new Date().getTime();

        while ((lines = fileReader.readLine()) != null)
        {
            String[] strArr = lines.split(" ");
            for(Map.Entry<Integer, String> entry: map.entrySet()){
                for(int i = 0; i < strArr.length; i++){
                    if(strArr[i].equals(String.valueOf(entry.getKey()))){
                        strArr[i] = entry.getValue();
                    }
                }
            }
            for(String s: strArr){
                System.out.print(s + " ");
            }
            //System.out.println(Arrays.toString(strArr));
        }
        reader.close();
        fileReader.close();
        long end = new Date().getTime();
        System.out.println(end - start);

    }
}
