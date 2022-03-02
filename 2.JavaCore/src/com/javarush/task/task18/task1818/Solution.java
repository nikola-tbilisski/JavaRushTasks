package com.javarush.task.task18.task1818;

import java.io.*;


/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException
        {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream file1output = new BufferedOutputStream(new FileOutputStream(reader.readLine(),true));
        BufferedInputStream file2Input = new BufferedInputStream(new FileInputStream(reader.readLine()));
        BufferedInputStream file3Input = new BufferedInputStream(new FileInputStream(reader.readLine()));

        byte[] buffer = new byte[(file2Input.available()) + (file3Input.available())];
        while (file2Input.available() > 0 && file3Input.available() > 0){
                int count1 = file2Input.read(buffer);
                file1output.write(buffer,0,count1);

                int count2 = file3Input.read(buffer);
                file1output.write(buffer,0,count2);
        }
        file2Input.close();
        file3Input.close();
        file1output.close();

    }
}
