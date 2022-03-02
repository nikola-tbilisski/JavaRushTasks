package com.javarush.task.task28.task2802;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/

public class Solution {

    public static class AmigoThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNum = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNum = new AtomicInteger(1);
        private final String namePref;

        AmigoThreadFactory() {
            SecurityManager sm = System.getSecurityManager();
            group = (sm != null) ? sm.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePref = group.getName() + "-" + "pool-" + poolNum.getAndIncrement() + "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread th = new Thread(group, r,
                            namePref + threadNum.getAndIncrement(), 0);

            if(th.isDaemon()) th.setDaemon(false);
            if(th.getPriority() != Thread.NORM_PRIORITY) th.setPriority(Thread.NORM_PRIORITY);

            return th;
        }
    }

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = () -> System.out.println(Thread.currentThread().getName());
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }
}
