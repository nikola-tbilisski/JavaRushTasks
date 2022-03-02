package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/* 
Составить цепочку слов
String... StringBuilder
*/

public class Solution {
    public static void main(String[] args) {
        //...
        String line;
        //List<String> wordList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))){

            while ((line = fileReader.readLine()) != null){
                    sb.append(line).append(" ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(sb.toString().trim());

        //StringBuilder result = getLine(sb.toString().trim());
        //assert result != null;
        System.out.println(getLine(sb.toString().trim().split("\\s+")));
    }

    public static StringBuilder getLine(String... words) {
        if (words.length == 0) return new StringBuilder();
        else if (words.length == 1) return new StringBuilder(words[0]);

        List<String> list = new ArrayList<>(Arrays.asList(words));
        StringBuilder sb = new StringBuilder();

        while (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (sb.length() == 0) {
                    sb.append(list.get(0));
                    list.remove(0);
                }
                if (sb.toString().toLowerCase().charAt(sb.length() - 1) == list.get(i).toLowerCase().charAt(0)) {
                    sb.append(" ").append(list.get(i));
                    list.remove(i);
                    i = -1;
                }
            }
            if (list.size() > 0) {
                list = new ArrayList<>(Arrays.asList(words));
                Collections.shuffle(list);
                sb = new StringBuilder();
            }
        }

        //System.out.println(wordList);

        return sb;
    }
}
