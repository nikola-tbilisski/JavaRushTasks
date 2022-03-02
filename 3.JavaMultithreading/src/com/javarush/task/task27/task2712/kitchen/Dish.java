package com.javarush.task.task27.task2712.kitchen;

import java.util.StringJoiner;

public enum Dish {
    FISH(25),
    STEAK(30),
    SOUP(15),
    JUICE(5),
    WATER(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString(){
        StringJoiner sj = new StringJoiner(", ");
        sj.add(FISH.name());
        sj.add(STEAK.name());
        sj.add(SOUP.name());
        sj.add(JUICE.name());
        sj.add(WATER.name());

        return sj.toString();
    }
}
