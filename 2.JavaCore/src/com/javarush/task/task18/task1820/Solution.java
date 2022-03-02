package com.javarush.task.task18.task1820;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException
        {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine(), fileName2 = reader.readLine();
        reader.close();

        BufferedReader file1Reader = new BufferedReader(new FileReader(fileName1));
        String[] currentLine = file1Reader.readLine().split(" ");
        Integer[] intArray = new Integer[currentLine.length];

            for(int i = 0; i < currentLine.length; i++){
                intArray[i] = Math.toIntExact(Math.round(Double.parseDouble(currentLine[i])));
                //System.out.print(intArray[i] + " ");
            }
            file1Reader.close();

        BufferedWriter file2Writer = new BufferedWriter(new FileWriter(fileName2));

            for (Integer i : intArray) {
                file2Writer.write(i + " ");
            }
            file2Writer.close();




    }
}
