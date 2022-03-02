package com.javarush.task.task14.task1419;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;
        } catch (Exception e) { exceptions.add(e);}

        try {
            String str = null;
            System.out.println(str.charAt(0));
        } catch (Exception e){ exceptions.add(e);}

        try {
            int[] ar = new int[6];
            ar[8] = 2;
        } catch (Exception e){ exceptions.add(e);}

        try {
            double d = Double.parseDouble("test");
            System.out.println(d);
        } catch (Exception e){ exceptions.add(e);}

        try {
            Class xuiegoZnaet = Class.forName("main.java.Utils");
            System.out.println("Class" + xuiegoZnaet + "found");
        } catch (Exception e){ exceptions.add(e);}

        FileInputStream input1 = null;
        try {
            input1 = new FileInputStream("D:/file.txt");
        } catch(Exception e) { exceptions.add(e);}

        try {
            String str = "Bulka";
            str.charAt(7);
        } catch (Exception e){ exceptions.add(e);}

        try {
            int i = -3;
            int[] ar = new int[i];
        } catch (Exception e){ exceptions.add(e);}

        try {
            List<Object> list = new ArrayList<>();
            list.add("NeXuiaSebe");
            int i = (int) list.get(0);
        } catch (Exception e){ exceptions.add(e);}

        try {
            Object ob[] = new String[10];
            ob[0] = '#';
        } catch (Exception e){ exceptions.add(e);}

        //напишите тут ваш код

    }
}
