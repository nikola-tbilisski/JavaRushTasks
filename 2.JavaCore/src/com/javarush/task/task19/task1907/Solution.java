package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException
        {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
        String text = null;

        while (fileReader.ready()){
            text = fileReader.readLine();
        }
        fileReader.close();

            if (text != null) {
                text = text.replaceAll("\\W+", " ");
                String[] wordsStr = text.split(" ");
                //System.out.println(Arrays.toString(wordsStr));
                System.out.println(wordsStr.length);
            }
        }
}
