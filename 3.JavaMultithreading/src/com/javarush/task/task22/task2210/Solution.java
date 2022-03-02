package com.javarush.task.task22.task2210;

import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/* 
StringTokenizer lambda
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTokens("level22.lesson13.task01.job12", ".")));
    }

    public static String[] getTokens(String query, String delimiter) {
       /* StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter); \\second version
        String[] gtArray = new String[stringTokenizer.countTokens()];

        for(int i = 0; i < gtArray.length; i++){
            gtArray[i] = stringTokenizer.nextToken();
        }*/

        return Collections.list(new StringTokenizer(query, delimiter)).stream()
                .map(token -> (String) token).toArray(String[]::new); //first version with lambda
    }
}
