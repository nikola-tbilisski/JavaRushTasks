package com.javarush.task.task18.task1801;

import java.io.*;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader path = new BufferedReader(new InputStreamReader(System.in));
        String filePath = path.readLine();
        //FileInputStream reader = new FileInputStream(filePath);
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(filePath));

        int max = 0, data;

        while (reader.available() > 0)
        {
            if((data = reader.read()) > max) max = data;

        }
        reader.close();
       System.out.println(max);
    }
}
