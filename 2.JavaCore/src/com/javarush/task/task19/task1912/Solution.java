package com.javarush.task.task19.task1912;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Ридер обертка 2
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(consoleStream);

        String resultStr = outputStream.toString();
        String finalStr = resultStr.replaceAll("te", "??");
        System.out.println(finalStr);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
