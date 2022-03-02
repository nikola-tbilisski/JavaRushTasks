package com.javarush.task.task33.task3305;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "className")
@JsonAutoDetect
public abstract class Vehicle {
    protected String name;
    protected String owner;
    protected int age;
}