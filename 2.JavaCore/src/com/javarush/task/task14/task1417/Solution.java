package com.javarush.task.task14.task1417;

import java.util.ArrayList;
import java.util.List;

/* 
Валюты
*/

public class Solution {
    public static void main(String[] args) {
        Person ivan = new Person("Иван");
        Person bob = new Person("Bob");
        for (Money money : ivan.getIvanallMoney()) {
            System.out.println(ivan.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());
        }
        System.out.println("\n");
        for(Money money: bob.getBoballMoney()){
            System.out.println(bob.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());
        }
    }

    static class Person {
        public String name;

        Person(String name) {
            this.name = name;
            this.ivanallMoney = new ArrayList<Money>();
            this.boballMoney = new ArrayList<>();
            //напишите тут ваш код
            ivanallMoney.add(new Hryvnia(200.4));
            ivanallMoney.add(new Ruble(4000.34));
            ivanallMoney.add(new USD(678.23));

            boballMoney.add(new USD(6035.67));
            boballMoney.add(new Ruble(0.0));
            boballMoney.add(new Hryvnia(892234.24));
        }

        private List<Money> ivanallMoney;
        private List<Money> boballMoney;

        public List<Money> getIvanallMoney() {
            return ivanallMoney;
        }
        public List<Money> getBoballMoney(){ return boballMoney;}
    }
}
