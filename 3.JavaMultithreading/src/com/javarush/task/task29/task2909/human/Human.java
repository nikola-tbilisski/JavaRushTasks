package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Task3: implement Alive
public class Human implements Alive {
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;
    //protected int course; //Task3: remove course field from Human
    private List<Human> children = new ArrayList<>();   //Task 1: children added to Human Class

    public List<Human> getChildren() {
        return Collections.unmodifiableList(this.children); //Task 1: Collections.unmodifiableList returned in getChild
    }


    public class Size {
        public int height, weight;
    }
    Size size;

    //protected boolean isSoldier; Task2: remove isSoldier from Human

//    public static final int FIRST = 1;
//    public static final int SECOND = 2;
//    public static final int THIRD = 3;
//    public static final int FOURTH = 4;
    private BloodGroup bloodGroup;

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
//        this.isSoldier = isSoldier;  //Task2: this values removed from Human constructor
//        this.id = nextId;
//        nextId++;
    }
    public void addChild(Human child) {
        children.add(child);
    } //Task1: addChild() added in Human Class

    public void removeChild(Human child) {
        children.remove(child);
    } //Task1: removeChild() added in Human Class

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public int getCourse() { //Task3: remove course getter from human
//        return course;
//    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }

    @Override
    public void live() {

    }

    public String getPosition(){
        return "Человек";
    }
}