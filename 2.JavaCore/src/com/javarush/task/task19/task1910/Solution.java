package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Пунктуация
*/

public class Solution
    {
        public static void main(String[] args) throws IOException
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String fileReadPath = reader.readLine();
                String fileWritePath = reader.readLine();
                reader.close();

                BufferedReader fileReader = new BufferedReader(new FileReader(fileReadPath));
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileWritePath));
                String str = null;

                while (fileReader.ready()) {
                    str = fileReader.readLine();
                }
                fileReader.close();

                final Pattern pattern = Pattern.compile("\\p{P}", Pattern.MULTILINE);
                assert str != null;
                final Matcher matcher = pattern.matcher(str);
                String resultStr = matcher.replaceAll("");
                fileWriter.write(resultStr);
                fileWriter.close();

                //System.out.println(resultStr);
            }
    }

