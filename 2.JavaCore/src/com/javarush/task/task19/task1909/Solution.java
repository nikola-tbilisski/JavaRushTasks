package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException
        {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileReadPath = reader.readLine();
        String fileWritePath = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileReadPath));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileWritePath));

        while (fileReader.ready()){
            int bytes = fileReader.read();
            if(bytes == 46){
                bytes = 33;
            }
            fileWriter.write((char) bytes);
        }
        fileReader.close();
        fileWriter.close();
    }
}
