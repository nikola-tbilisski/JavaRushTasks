package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        Properties properties = new Properties();
        for(Map.Entry<String, String> entry: runtimeStorage.entrySet()){
            properties.setProperty(entry.getKey(), entry.getValue());
            properties.store(outputStream, properties.getProperty(entry.getKey(), entry.getValue()));
        }

    }

    public static void load(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);

        Set<String> propertyKeys = properties.stringPropertyNames();
        for(String s: propertyKeys){
            if(!s.equals("--")){
                runtimeStorage.put(s, properties.getProperty(s));
            }
        }
        //напишите тут ваш код
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Map.Entry<String, String> entry: runtimeStorage.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
