package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Объединение файлов
*/

public class Solution
    {
        public static void main(String[] args) throws IOException
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String filePath1 = reader.readLine(), filePath2 = reader.readLine();
                reader.close();
                List<String> listText = new ArrayList<>();

                BufferedReader fileReader1 = new BufferedReader(new FileReader(filePath1));
                BufferedReader fileReader2 = new BufferedReader(new FileReader(filePath2));

                while (fileReader1.ready() && fileReader2.ready()) {

                    listText.add(fileReader2.readLine());
                    listText.add(fileReader1.readLine());
                }
                BufferedWriter fileWriter1 = new BufferedWriter(new FileWriter(filePath1));

                for(String s: listText){
                    fileWriter1.write(s);
                }
                fileWriter1.close();

                fileReader1.close();
                fileReader2.close();


            }
    }