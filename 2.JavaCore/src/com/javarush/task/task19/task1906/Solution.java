package com.javarush.task.task19.task1906;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Четные символы
*/

public class Solution
    {
        public static void main(String[] args) throws IOException
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String fileNameRead = reader.readLine();
                String fileNameWrite = reader.readLine();
                reader.close();
                List<Integer> byteList = new ArrayList<>();

                FileReader fileReader = new FileReader(fileNameRead);

                while (fileReader.ready()){
                    int bytes = fileReader.read();
                    byteList.add(bytes);
                    //System.out.println(bytes);
                }
                fileReader.close();

                FileWriter fileWriter = new FileWriter(fileNameWrite);

                for(int i = 1; i < byteList.size(); i += 2){
                        //char ch = ((char) byteList.get(i).byteValue());
                        fileWriter.write(((char) byteList.get(i).byteValue()));
                }
                fileWriter.close();

               /* for(Integer i: byteList){
                    System.out.println(i);
                }*/



            }
    }
