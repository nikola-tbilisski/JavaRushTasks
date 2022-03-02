package com.javarush.task.task28.task2813;

import java.util.concurrent.Callable;

public class FactorialCalculator implements Callable<Long> {
    private final int number;

    public FactorialCalculator(int number) {
        this.number = number;
    }

    @Override
    public Long call() {
        long res = 0;
        try {
            res = factorial(number);
        } catch (InterruptedException e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    public long factorial(int number) throws InterruptedException {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be greater than zero");
        }
        long result = 1;
        while (number > 1) {
            Thread.sleep(1);
            result = result * number;
            number--;
        }
        return result;
    }
}
