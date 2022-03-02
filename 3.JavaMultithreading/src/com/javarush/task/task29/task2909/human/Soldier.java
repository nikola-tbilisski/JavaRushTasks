package com.javarush.task.task29.task2909.human;

//Task2: create Class Soldier and extend it with Human Class
public class Soldier extends Human {

    public Soldier(String name, int age) {
        super(name, age);
    } //Task2: Soldier constructor modified according to super Class

    public void live() { fight(); } //Task2: live() override for Soldier

    public void fight() {
    }   //Task2: fight() shifted from Human to Soldier
}
