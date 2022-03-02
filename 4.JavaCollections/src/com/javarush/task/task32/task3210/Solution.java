package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
//        String pathToFile = args[0];
//        String number = args[1];
//        String textToInsert = args[2];
        //boolean equalText = false;

        try(RandomAccessFile accessFile = new RandomAccessFile(args[0], "rw");) {
            accessFile.seek(Long.parseLong(args[1]));

            byte[] readTextBytes = new byte[args[2].length()];
            accessFile.read(readTextBytes, 0, args[2].length());
            String readText = new String(readTextBytes, StandardCharsets.UTF_8);

            accessFile.seek(accessFile.length());
            if(readText.equals(args[2])){
                accessFile.write("true".getBytes());
            } else {
                accessFile.write("false".getBytes());
            }
            //System.out.println(readText);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
