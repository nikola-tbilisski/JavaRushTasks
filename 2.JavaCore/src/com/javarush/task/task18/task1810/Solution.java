package com.javarush.task.task18.task1810;

import java.io.*;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedInputStream inputStream;

        while ((inputStream = new BufferedInputStream(new FileInputStream(reader.readLine()))).available() > 999){

        }
        inputStream.close();
        throw new DownloadException();
    }

    public static class DownloadException extends Exception {

    }
}
