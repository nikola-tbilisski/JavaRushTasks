package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(args[0]));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(args[1]));){

            //Charset currentCharset = Charset.defaultCharset();
            //System.out.println(currentCharset);
            Charset windows1251 = Charset.forName("Windows-1251");
            Charset utf8 = StandardCharsets.UTF_8;



            byte[] buffer = new byte[bis.available()];

            while (bis.available() > 0){
                bis.read(buffer);
                //System.out.println(Arrays.toString(buffer));
            }

            String str = new String(buffer, windows1251);
            buffer = str.getBytes(utf8);
            bos.write(buffer);
            //System.out.println(Arrays.toString(str.getBytes(utf8)));

        }
    }
}
