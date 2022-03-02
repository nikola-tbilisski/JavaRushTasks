package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException
        {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedInputStream fileInput = new BufferedInputStream(new FileInputStream(reader.readLine()));
        BufferedOutputStream fileOutput = new BufferedOutputStream(new FileOutputStream(reader.readLine()));
        //int count;

        byte[] buffer = new byte[fileInput.available()];
        while (fileInput.available() > 0){
            fileInput.read(buffer);
        }
        fileInput.close();

        for(int i = buffer.length - 1; i >= 0; i--){
            fileOutput.write(buffer[i]);
        }
        fileOutput.close();

    }
}
