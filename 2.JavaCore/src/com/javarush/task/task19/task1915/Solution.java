package com.javarush.task.task19.task1915;

import java.io.*;
import java.nio.charset.StandardCharsets;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException
        {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        reader.close();

        PrintStream console = System.out;
        ByteArrayOutputStream baoS = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baoS));

        testString.printSomething();
        String resultStr = baoS.toString();
        System.setOut(console);

        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));
        outputStream.write(resultStr.getBytes(StandardCharsets.UTF_8));
        outputStream.close();

        System.out.println(resultStr);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

