package com.javarush.task.task18.task1824;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файлы и исключения
*/
//Input Output + try/catch know where to close fileReader!

public class Solution {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static String filename;
    public static BufferedReader fileReader;
    public static void main(String[] args) throws IOException
        {
       
        try {
            while ((filename = reader.readLine()) != null){
                fileReader = new BufferedReader(new FileReader(filename));
                fileReader.close();
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println(filename);
        }

    }
}
