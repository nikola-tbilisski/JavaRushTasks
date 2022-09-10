package com.javarush.task.task29.task2909.human;

public class Teacher extends UniversityPerson {
    //private List<Human> children = new ArrayList<>(); //Task1: children List removed from Teacher Class
    private int numberOfStudents;
    //private String university;

    public Teacher(String name, int age, int numberOfStudents) { //Task2: Teacher constructor modified according to super Class
        super(name, age);
        this.numberOfStudents = numberOfStudents;
    }

//    public List<Human> getChildren() { //Task1: children getter and setter removed from Teacher Class
//        return children;
//    }
//
//    public void setChildren(List<Human> children) {
//        this.children = children;
//    }

    public void live() {
        teach();
    }

    public void teach() {
    }

//    public String getUniversity() {
//        return university;
//    }
//
//    public void setUniversity(String university) {
//        this.university = university;
//    }

//    public void printData() {
//        System.out.println(getPosition() + ": " + name);
//    }

    @Override
    public String getPosition() {
        return "Преподаватель";
    }
}