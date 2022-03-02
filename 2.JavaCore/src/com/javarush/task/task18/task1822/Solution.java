package com.javarush.task.task18.task1822;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

       BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        List<String> strList = new ArrayList<>();

        while (fileReader.ready()){
            strList.add(fileReader.readLine());
        }
        fileReader.close();

       for(int i =0; i < strList.size(); i++){
           String[] id = strList.get(i).split(" ");
           System.out.println(id[0]);
           if(strList.get(i).startsWith(args[0] + " ")){
               System.out.println(strList.get(i));
           }
           //System.out.println(strList.get(i));
       }


    }
}
