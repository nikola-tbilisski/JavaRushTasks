package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
*/

public class Solution {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        final transient String greeting;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greeting = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        @Override
        public String toString()
            {
                return "Person{" +
                        "firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", fullName='" + fullName + '\'' +
                        ", greeting='" + greeting + '\'' +
                        ", country='" + country + '\'' +
                        ", sex=" + sex +
                        ", outputStream=" + outputStream +
                        '}';
            }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) {
        try {
            OutputStream fos = new FileOutputStream("myfile.log");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            Person person1 = new Person("Nikola", "Kvanto", "Georgia", Sex.MALE);
            oos.writeObject(person1);

            InputStream fis = new FileInputStream("myfile.log");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Person person2 = new Person("Luda", "Xuiglot", "Russia", Sex.FEMALE);
            person2 = (Person) ois.readObject();

            System.out.println(person1.equals(person2));
            System.out.println(person1);
            System.out.println(person2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
