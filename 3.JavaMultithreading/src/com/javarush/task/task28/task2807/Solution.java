package com.javarush.task.task28.task2807;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Знакомство с ThreadPoolExecutor
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Runnable> runnableQueue = new LinkedBlockingQueue<>();
        AtomicInteger lID = new AtomicInteger();

        for(int i = 0; i < 10; i++){
            runnableQueue.add(() -> doExpensiveOperation(lID.incrementAndGet()));
        }

        ThreadPoolExecutor tpe = new ThreadPoolExecutor(3,
                                                        5,
                                                        1000L,
                                                        TimeUnit.MILLISECONDS, runnableQueue);

        tpe.prestartAllCoreThreads();
        tpe.shutdown();
        tpe.awaitTermination(5, TimeUnit.SECONDS);

        // Add your code here

        /* Example output
pool-1-thread-2, localId=2
pool-1-thread-3, localId=3
pool-1-thread-1, localId=1
pool-1-thread-3, localId=5
pool-1-thread-2, localId=4
pool-1-thread-3, localId=7
pool-1-thread-1, localId=6
pool-1-thread-3, localId=9
pool-1-thread-2, localId=8
pool-1-thread-1, localId=10
         */
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}
