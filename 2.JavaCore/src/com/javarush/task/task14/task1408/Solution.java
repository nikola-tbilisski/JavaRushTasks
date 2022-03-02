package com.javarush.task.task14.task1408;
/*
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
        System.out.println(hen.getDescription());
        hen = HenFactory.getHen(Country.RUSSIA);
        System.out.println(hen.getDescription());
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            switch (country){
                case Country.RUSSIA:
                    return new RussianHen();
                case Country.UKRAINE:
                    return new UkrainianHen();
                case Country.MOLDOVA:
                    return new MoldovanHen();
                case Country.BELARUS:
                    return new BelarusianHen();
                default:
                    break;
            }
            //напишите тут ваш код
            return hen;
        }
    }

}

abstract class Hen{
    abstract int getCountOfEggsPerMonth();
    String getDescription(){ return "Я - курица.";}
}
