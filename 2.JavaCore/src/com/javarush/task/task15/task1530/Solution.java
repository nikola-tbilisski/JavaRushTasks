package com.javarush.task.task15.task1530;

/* 
Template pattern
*/

public class Solution {
    public static void main(String[] args) {
        DrinkMaker cofDrink = new LatteMaker();
        DrinkMaker teaDrink = new TeaMaker();

        cofDrink.makeDrink();
        teaDrink.makeDrink();
    }
}
