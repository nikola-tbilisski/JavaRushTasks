package com.javarush.task.task18.task1826;

import java.io.*;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException
        {
        BufferedInputStream fileInput = new BufferedInputStream(new FileInputStream(args[1]));
        BufferedOutputStream fileOutput = new BufferedOutputStream(new FileOutputStream(args[2]));

        byte[] buffer = new byte[fileInput.available()];

        switch (args[0])
        {
            case "-e": {
                while (fileInput.available() > 0){
                    fileInput.read(buffer);
                }
                fileInput.close();

                for(int i = buffer.length - 1; i >= 0; i--){
                    fileOutput.write(buffer[i] - 128);
                }
                fileOutput.close();
            }
            break;

            case "-d": {
                while (fileInput.available() > 0){
                    fileInput.read(buffer);
                }
                fileInput.close();

                for(int i = buffer.length - 1; i >= 0; i--){
                    fileOutput.write(buffer[i] + 128);
                }
                fileOutput.close();
            }
            break;
        }

    }

}
