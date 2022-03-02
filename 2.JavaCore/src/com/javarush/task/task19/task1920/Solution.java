package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Самый богатый
*/
//TreeMap Collections calculate maximum double value from txt file

public class Solution {
    public static void main(String[] args) throws IOException
        {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));

        Map<String, Double> strMap = new TreeMap<>();
        String lines;
        String max = null;

        while ((lines = fileReader.readLine()) != null) {
            String[] str = lines.split(" ");
            String name = str[0];
            Double value = Double.parseDouble(str[1]);
            if(strMap.containsKey(name)){
                for(Map.Entry<String, Double> entry: strMap.entrySet()){
                    if(entry.getKey().equals(name)){
                        value += entry.getValue();
                    }
                }
            }
            strMap.put(name, value);
        }
        fileReader.close();
        Double maxValue = Collections.max(strMap.values());

        for(Map.Entry<String, Double> entry: strMap.entrySet()){
            if(entry.getValue().equals(maxValue)) System.out.println(entry.getKey());
        }
            //System.out.println(maxValue);
           /* strMap.forEach((String, Double)->{
                if (Double.equals(Collections.max(strMap.values()))) { System.out.println(String);} });
        };*/
    }
}
