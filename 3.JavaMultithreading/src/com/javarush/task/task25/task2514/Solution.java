package com.javarush.task.task25.task2514;

/* 
Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
*/

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;
        Thread thread;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("begin-" + index);
            Thread.yield();

            System.out.println("end-" + index);
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        for(int i = 1; i <= 100; i ++){
            service.execute(new YieldRunnable(i));
        }
        service.shutdown();
    }
}
