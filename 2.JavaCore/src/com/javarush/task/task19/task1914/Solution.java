package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(console);
        String[] strArr = result.split(" ");

        switch (strArr[1])
        {
            case "+":
                int res = Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[2]);
                System.out.print(result + res);
                break;

            case "-":
                res = Integer.parseInt(strArr[0]) - Integer.parseInt(strArr[2]);
                System.out.print(result + res);
                break;

            case "*":
                res = Integer.parseInt(strArr[0]) * Integer.parseInt(strArr[2]);
                System.out.print(result + res);
                break;

            default:
                break;

        }

       //System.out.println(Arrays.toString(strArr));
    }

    public static class TestString {
        public void printSomething() {
            System.out.print("3 + 6 = ");
        }
    }
}

