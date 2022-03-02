package com.javarush.task.task19.task1911;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

/* 
Ридер обертка
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);

        System.out.println(result.toUpperCase(Locale.ROOT));

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
