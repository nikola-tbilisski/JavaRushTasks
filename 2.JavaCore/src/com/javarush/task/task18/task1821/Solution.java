package com.javarush.task.task18.task1821;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException
        {
        BufferedInputStream fileInput = new BufferedInputStream(new FileInputStream(args[0]));
        Map<Byte, Integer> mapSymbols = new HashMap<>();

        byte[] buffer = new byte[fileInput.available()];

        while (fileInput.available() > 0){
            fileInput.read(buffer);
            Arrays.sort(buffer);
        }

        int count;
        for(byte b1: buffer){
            count = 0;
            //System.out.print((char) b1 + " ");
            for(byte b2: buffer){
                if(b1 == b2) count++;
            }
            if(!mapSymbols.containsKey(b1)){
                mapSymbols.put(b1, count);
                System.out.println((char) b1 + " " + count);
            }
        }
        fileInput.close();

    }
}
