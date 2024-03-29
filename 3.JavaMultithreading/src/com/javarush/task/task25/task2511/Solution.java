package com.javarush.task.task25.task2511;

import java.util.Timer;
import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/

public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        new Thread.UncaughtExceptionHandler(){

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(e.getMessage().replaceAll(t.getName(), t.getName().replaceAll(".", "*")));
            }
        };
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = (t,e)-> System.out.println(e.getMessage().replace(t.getName(), t.getName().replaceAll(".","*")));    //init handler here
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
        TimerTask timerTask = new Solution(new TimerTask() {
            @Override
            public void run() {
                throw new UnsupportedOperationException();
            }
        });
        new Timer().scheduleAtFixedRate(timerTask, 0, 1000);
    }
}
