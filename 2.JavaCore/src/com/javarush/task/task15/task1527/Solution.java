package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException
        {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String url = reader.readLine();
        int ind = url.indexOf("?");
        String par1 = url.substring(ind + 1);
            //System.out.println(par1);
        String value = "";

        for(String tmp : par1.split("&")){
            int i = 0;

            for(String t1 : tmp.split("=")){
                if(i == 0)
                    list.add(t1);
                i ++;
                if(t1.contentEquals("obj")) {
                    value = tmp.substring(4);
                    //System.out.println(value);
                }

            }

        }

        for(String str : list){
            System.out.println(str + "");
        }

            System.out.println();

        if(value != ""){

            try {
                alert(Double.parseDouble(value));
            }
            catch (Exception e){
                alert(value);
            }
        }
        //add your code here
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
