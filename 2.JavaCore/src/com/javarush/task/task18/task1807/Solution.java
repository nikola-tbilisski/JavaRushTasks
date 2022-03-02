package com.javarush.task.task18.task1807;

import java.io.*;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader filepath = new BufferedReader(new InputStreamReader(System.in));
        String fileName = filepath.readLine();
        BufferedInputStream fileRead = new BufferedInputStream(new FileInputStream(fileName));
        int count = 0;

        while (fileRead.available() > 0){
            if(fileRead.read() == 44){
                count++;
            }
        }
        fileRead.close();
        System.out.println(count);
    }
}
