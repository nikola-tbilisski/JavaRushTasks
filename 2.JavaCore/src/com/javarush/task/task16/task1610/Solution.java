package com.javarush.task.task16.task1610;

/* 
Расставь вызовы методов join()
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Cat cat1 = new Cat("Мурка");
        Cat cat2 = new Cat("Пушинка");
    }

    private static void investigateWorld() throws InterruptedException
        {
            Thread.sleep(200);
        }

    public static class Cat extends Thread {
        protected Kitten kitten1;
        protected Kitten kitten2;

        public Cat(String name)
            {
            super(name);
            kitten1 = new Kitten("Котенок 1, мама - " + getName());
            //kitten1.join();
            kitten2 = new Kitten("Котенок 2, мама - " + getName());
            //kitten2.join();
            start();
        }

        public void run() {
            System.out.println(getName() + " родила 2 котенка");
            try {
                initAllKittens();
            } catch (InterruptedException e) {
            }
            System.out.println(getName() + ": Все котята в корзинке. " + getName() + " собрала их назад");
        }

        private void initAllKittens() throws InterruptedException {
            kitten1.start();
            kitten1.join();
            kitten2.start();
            kitten2.join();
        }
    }

    public static class Kitten extends Thread {
        public Kitten(String name) {
            super(name);
        }

        public void run() {
            System.out.println(getName() + ", вылез из корзинки");
            try {
                investigateWorld();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
