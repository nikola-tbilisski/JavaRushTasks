package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) {
        try(RandomAccessFile  accessFile = new RandomAccessFile(Paths.get(args[0]).toFile(), "rw")) {
            if(accessFile.length() < Integer.parseInt(args[1])){
                accessFile.seek(accessFile.length());
            }else {
                accessFile.seek(Long.parseLong(args[1]));
            }
            accessFile.write(args[2].getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
