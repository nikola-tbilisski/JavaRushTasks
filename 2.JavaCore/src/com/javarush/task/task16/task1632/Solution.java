package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static
    {
        threads.add(new Thread(new First()));
        threads.add(new Thread(new Second()));
        threads.add((new Thread(new Third())));
        threads.add(new Fourth());
        threads.add(new Thread(new Fifth()));
    }

    public static void main(String[] args) {
        //threads.get(0).start();
        //threads.get(1).start();
        //threads.get(2).start();
        //threads.get(3).start();
        //threads.get(4).start();
    }

    public static class First implements Runnable{

        @Override
        public void run()
            {
                System.out.println("First: " + Thread.currentThread().getName());
                while (true){}
            }
    }

    public static class Second implements Runnable{

        @Override
        public void run()
            {
                try {
                    Thread.sleep(250);
                    System.out.println("Second: " + Thread.currentThread().getName());

                } catch (InterruptedException e){
                    System.out.println("InterruptedException");
                }
            }
    }

    public static class Third implements Runnable{

        @Override
        public void run()
            {
                //System.out.println("Third: " + Thread.currentThread().getName());
                while (true) {
                    System.out.println("Ура");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
    }

    public static class Fourth extends Thread implements Message{

        @Override
        public void run()
            {
               while (!isInterrupted())
               {
                   //showWarning();
               }
            }

        @Override
        public void showWarning()
            {
                System.out.println("Interrupt the thread: " + Thread.currentThread().getName());
                interrupt();
            }
    }

    public static class Fifth implements Runnable{
        @Override
        public void run()
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                int sum = 0;

                while (true) {
                    try {
                        String sInp = reader.readLine();
                        if (sInp.contentEquals("N")) break;
                        sum += Integer.parseInt(sInp);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(sum);

            }
    }
}