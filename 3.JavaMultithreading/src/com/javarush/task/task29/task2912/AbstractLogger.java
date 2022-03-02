package com.javarush.task.task29.task2912;

public abstract class AbstractLogger implements Logger {
    private int level;
    private Logger next;

    protected AbstractLogger(int level) {
        this.level = level;
    }

    @Override
    public void inform(String message, int level) {
        if (this.level <= level) {
            info(message);
        }
        if (next != null) {
            next.inform(message, level);
        }
    }

    @Override
    public void setNext(Logger next) {
        this.next = next;
    }

//    @Override
//    public void info(String message) {
//
//    }
}
