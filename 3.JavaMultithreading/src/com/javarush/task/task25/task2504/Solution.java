package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/

import java.util.Arrays;

public class Solution {
    public static void processThreads(Thread... threads) {
        for(Thread thr: threads) {
            switch (thr.getState()) {
                case NEW:
                    thr.start();
                    break;

                case BLOCKED:
                case TIMED_WAITING:
                case WAITING:
                    thr.interrupt();
                    break;

                case RUNNABLE:
                    thr.isInterrupted();
                    break;

                case TERMINATED:
                    System.out.println(thr.getPriority());
                    break;
            }
        }
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread();
        Thread thread2 = new Thread();
        Thread thread3 = new Thread();

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.interrupt();


        processThreads(thread1, thread2, thread3);
    }
}
