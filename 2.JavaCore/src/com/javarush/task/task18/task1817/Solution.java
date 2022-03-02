package com.javarush.task.task18.task1817;

import java.io.*;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException
        {
        BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream(args[0]));
        int spCount = 0, smbCount = 0;

        while (fileInputStream.available() > 0) {
            char c = (char) fileInputStream.read();
            if (Character.isLetterOrDigit(c)) {
                smbCount++;
            } else if (Character.isWhitespace(c)) {
                spCount++;
            } else smbCount++;
        }
        fileInputStream.close();
           // System.out.println(smbCount+" "+spCount);
        //float result = spCount / smbCount * 100;
            System.out.printf("%.2f", (float) spCount / (smbCount + spCount) * 100);
    }
}
