package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/* 
Десериализация JSON объекта
*/

public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(fileName);

        return mapper.readValue(file, clazz);
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Cat cat = convertFromJsonToNormal("c:/temp/jsonobject.json", Cat.class);
        String result = mapper.writeValueAsString(cat);
        System.out.println(result);
    }

    public static class Cat {
        public String wildAnimal;
        public int age, weight;
        public String about;

    }

}
