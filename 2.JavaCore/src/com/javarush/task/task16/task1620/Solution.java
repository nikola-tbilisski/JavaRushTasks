package com.javarush.task.task16.task1620;

import java.util.ArrayList;
import java.util.List;

/* 
Один для всех, все - для одного
*/

public class Solution {
    public static byte threadCount = 10;
    static List<Thread> threads = new ArrayList<Thread>(threadCount);

    public static void main(String[] args) throws InterruptedException {
        initThreadsAndStart();
        Thread.sleep(3000);
        ourInterruptMethod();
    }

    public static void ourInterruptMethod() {
        for(Thread thr : threads){
            thr.interrupt();
        }
        //add your code here - добавь код тут
    }

    private static void initThreadsAndStart() {
        Water water = new Water("water");
        for (int i = 0; i < threadCount; i++) {
            threads.add(new Thread(water, "#" + i));
        }

        for (int i = 0; i < threadCount; i++) {
            threads.get(i).start();
        }
    }

    public static class Water implements Runnable {
        private String sharedResource;

        public Water(String sharedResource) {
            this.sharedResource = sharedResource;
        }

        public void run() {
            boolean isCurrentThreadInterrupted = Thread.currentThread().isInterrupted();
            String threadName = Thread.currentThread().getName();
            //fix 2 variables - исправь 2 переменных
            try {
                while (!isCurrentThreadInterrupted) {

                    System.out.println("Объект " + sharedResource + ", нить " + threadName);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
            }
        }
    }
}
