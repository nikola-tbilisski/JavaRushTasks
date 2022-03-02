package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> trMap = new TreeMap<>();
        String lines;

        while ((lines = fileReader.readLine()) != null)
        {
            String[]str = lines.split(" ");
            String name = str[0];
            Double value = Double.parseDouble(str[1]);
            if(trMap.containsKey(name)){
                for(Map.Entry<String, Double> entry: trMap.entrySet()){
                    if(entry.getKey().equals(name)) {
                        value += entry.getValue();
                    }
                }
            }
            trMap.put(name, value);
        }
        fileReader.close();

        for(Map.Entry<String, Double> entry: trMap.entrySet()){
            System.out.printf("%s: %.2f \n", entry.getKey(), entry.getValue());
        }

    }
}
