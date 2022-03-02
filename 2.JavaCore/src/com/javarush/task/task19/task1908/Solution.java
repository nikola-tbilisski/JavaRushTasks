package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Выделяем числа
*/

public class Solution
    {
        public static void main(String[] args) throws IOException
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String fileInput = reader.readLine();
                String filOutput = reader.readLine();
                reader.close();

                BufferedReader fileReader = new BufferedReader(new FileReader(fileInput));
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filOutput));
                String text, finalText = null;

                while (fileReader.ready()) {
                    text = fileReader.readLine();
                    //String regex = "(\\b\\d+\\b)";
                    String regex = "(([a-zA-Z]+)([0-9]+))|(([0-9]+)([a-zA-Z]+))|(([0-9]+)([а-яА-Я]+))|(([а-яА-Я]+)([0-9]+))|([a-zA-Z]+)|([а-яА-Я]+)";
                    String subst = "";
                    final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
                    final Matcher matcher = pattern.matcher(text);
                    finalText = matcher.replaceAll(subst);
                    finalText = finalText.replaceAll("\\s+", " ");
                    fileWriter.write(finalText);
                }
                fileReader.close();
                fileWriter.close();
                System.out.println(finalText);


            }
    }
