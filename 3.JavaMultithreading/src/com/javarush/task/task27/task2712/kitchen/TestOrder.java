package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class TestOrder extends Order{
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        this.dishes = new ArrayList<>();
        Dish[] value = Dish.values();

        int dishCount = ThreadLocalRandom.current().nextInt(2, 5);

        for(int i = 0; i < dishCount; i++){
            int dishInd = ThreadLocalRandom.current().nextInt(value.length);
            dishes.add(value[dishInd]);
        }
    }
}
