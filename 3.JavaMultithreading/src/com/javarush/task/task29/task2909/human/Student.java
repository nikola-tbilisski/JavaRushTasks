package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends UniversityPerson {
    //private List<Human> children = new ArrayList<>(); //Task1: children List removed from Student Class
    private double averageGrade;
    //private String university;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public int getCourse() {
        return course;
    }

    public Student(String name, int age, double averageGrade) { //Task2: Student constructor modified according to super Class
        super(name, age);
        this.averageGrade = averageGrade;
    }

//    public List<Human> getChildren() { //Task1: List children getter and setter removed from Student
//        return children;
//    }
//
//    public void setChildren(List<Human> children) {
//        this.children = children;
//    }

    public void live() {
        learn();
    }

    public void learn() {
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

//    public void incAverageGradeBy01() {
//        averageGrade += 0.1;
//    }

//    public void incAverageGradeBy02() {
//        averageGrade += 0.2;
//    }

    public void incAverageGrade(double delta) {
        double ag = getAverageGrade();
        setAverageGrade(ag += delta);
    }

//    public void setValue(String name, double value) {
//        if (name.equals("averageGrade")) {
//            averageGrade = value;
//            return;
//        }
//        if (name.equals("course")) {
//            course = (int) value;
//            return;
//        }
//    }

    public void setCourse(int course) {
       this.course = course;
    }

    public void setAverageGrade(double averageGrade){
        this.averageGrade = averageGrade;
    }

    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    

    @Override
    public String getPosition() {
        return "Студент";
    }
}