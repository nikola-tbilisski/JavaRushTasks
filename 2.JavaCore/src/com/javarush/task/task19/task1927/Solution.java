package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream baoS = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baoS));

        testString.printSomething();
        String[] res = baoS.toString().split("\n");
        System.setOut(console);

       for(int i = 0; i< res.length; i++){
           System.out.println(res[i]);
           if(i % 2 != 0){
               System.out.println("JavaRush - курсы Java онлайн");
           }
       }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
