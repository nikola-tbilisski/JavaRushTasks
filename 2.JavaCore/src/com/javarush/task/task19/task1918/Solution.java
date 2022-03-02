package com.javarush.task.task19.task1918;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Знакомство с тегами
*/

public class Solution
    {
        //public static List<String> tagList = new ArrayList<>();
       // public static List<String> htmlList = new ArrayList<>();

        public static void main(String[] args) throws IOException
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
                reader.close();
                String lines, text;
                StringBuilder stringBuilder = new StringBuilder();

                while ((lines = fileReader.readLine()) != null) {
                    stringBuilder.append(lines);
                }
                fileReader.close();
                //System.out.println(stringBuilder.toString());


                if(!(args[0].isEmpty())) {
                    Document document = Jsoup.parse(stringBuilder.toString());
                    Elements elem = document.select(args[0]);
                    for (Element elements : elem) {
                        System.out.println(elements);
                    }
                }

                //text = stringBuilder.toString();
                //htmlList.forEach(System.out::println);
                //System.out.println(stringBuilder.toString());


                /* if (!(args[0].isEmpty())){
                     String tag = args[0];
                    final String regex1 = "(<"+tag+"\\D*>\\D*</"+tag+"></\\w></"+tag+">)";
                    final Pattern pattern1 = Pattern.compile(regex1, Pattern.MULTILINE);
                    final Matcher matcher1 = pattern1.matcher(text);
                    while (matcher1.find()) {
                        System.out.println(matcher1.group(0));
                        //tagList.add(matcher1.group(0));
                    }

                    final String regex2 = "(<"+tag+">\\w*\\s*\\w*</"+tag+">)";
                    final Pattern pattern2 = Pattern.compile(regex2, Pattern.MULTILINE);
                    final Matcher matcher2 = pattern2.matcher(text);
                    while (matcher2.find()) {
                        System.out.println(matcher2.group(0));
                    }


                }*/
            }
    }
