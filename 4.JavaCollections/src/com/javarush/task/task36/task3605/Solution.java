package com.javarush.task.task36.task3605;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Set<Character> charSet = new TreeSet<>();

//        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(args[0]))) {
//            byte[] buffer = new byte[bis.available()];
//
//            bis.read(buffer);
//            System.out.println(Arrays.toString(buffer));
//
//            for (byte b : buffer) {
//                char ch = (char) b;
//                if (Character.isLetter(ch)) {
//                    charSet.add(Character.toLowerCase(ch));
//                }
//            }
//        }

        byte[] bytes = Files.readAllBytes(Paths.get(args[0]));

        for (byte b : bytes) {
            char ch = (char) b;
            if (Character.isLetter(ch)) {
                charSet.add(Character.toLowerCase(ch));
            }
        }

        charSet.stream().limit(5).forEach(System.out::print);
    }
}
