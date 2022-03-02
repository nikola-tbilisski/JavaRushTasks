package com.javarush.task.task18.task1802;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader filePath = new BufferedReader(new InputStreamReader(System.in));
        String path = filePath.readLine();
        BufferedInputStream readFile = new BufferedInputStream(new FileInputStream(path));
        int data, min = 0, i;
        data = readFile.read();

       while (readFile.available() > 0){
           if((i =  readFile.read()) < data) min = i;
       }

        readFile.close();
        System.out.println(min);
    }
}
