package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/
//matches FileWriter
public class Solution {
    public static void main(String[] args) throws IOException
        {
        //String file1Name = args[0], file2Name = args[1];

        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
        String lines;

        while ((lines = fileReader.readLine()) != null){
            String[] str = (lines.split(" "));
            for(String s: str){
                if(s.matches("\\S*\\d+\\S*")){
                    fileWriter.write(s+" ");
                    System.out.print(s+" ");
                }

            }
            //String wordsDigits = lines.replaceAll("\\b[a-zA-Zа-яА-Я]+\\b", "");
            //System.out.print(wordsDigits);
            //fileWriter.write(wordsDigits);
        }
        fileReader.close();
        fileWriter.close();
    }
}
