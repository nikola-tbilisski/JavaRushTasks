package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if(string == null) throw new TooShortStringException();

        String[] str = string.split("\\t");
        int tabs = string.replaceAll("[^\\t]", "").length();
        System.out.println(tabs);
        if(tabs < 2) throw new TooShortStringException();

        return str[1].trim();
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\t JavaRush - лучший \tсервис\t обучения\t Java.\t"));
    }
}
