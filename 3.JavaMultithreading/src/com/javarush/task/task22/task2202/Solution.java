package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        //StringBuilder st = new StringBuilder();
        String result = null;
        try {
            String[] str = string.split("\\s");
            result = String.format("%s %s %s %s", str[1], str[2], str[3], str[4]);
            //Arrays.stream(str).skip(1).limit(4).forEach(word -> st.append(word).append(" "));
        } catch (Exception e){
            if(string == null || string.isEmpty() || string.split(" ").length < 5){
                throw new TooShortStringException();
            }
        }


        return result;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
