package com.javarush.task.task18.task1816;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
            BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream(args[0]));
            int count = 0;

            while (fileInputStream.available() > 0) {
                char c = (char) fileInputStream.read();
                if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {count++;}
            }
            fileInputStream.close();

            System.out.println(count);
    }
}
