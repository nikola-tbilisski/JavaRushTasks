package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
    public static SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MMM/yyyy");

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException{
            Person person = null;

            switch (args[0])
            {
                case "-c": {
                    if(args[2].equals("м")){
                        person = Person.createMale(args[1], dateFormat1.parse(args[3]));
                        allPeople.add(person);
                    }
                    else if(args[2].equals("ж")){
                        person = Person.createFemale(args[1], dateFormat1.parse(args[3]));
                        allPeople.add(person);
                    }
                    System.out.println(allPeople.indexOf(person));
                    break;
                }

                case "-u": {
                    person = allPeople.get(Integer.parseInt(args[1]));
                    person.setName(args[2]);
                    if(args[3] == "м"){person.setSex(Sex.MALE);}
                    else if(args[3] == "ж"){person.setSex(Sex.FEMALE);}
                    person.setBirthDate(dateFormat1.parse(args[4]));
                    break;
                }

                case "-d": {
                    person = allPeople.get(Integer.parseInt(args[1]));
                    person.setName(null);
                    person.setSex(null);
                    person.setBirthDate(null);
                    break;
                }

                case "-i": {
                    person = allPeople.get(Integer.parseInt(args[1]));
                    String sex = null;
                    if(person.getSex().equals(Sex.MALE)){sex = "м";}
                    else if(person.getSex().equals(Sex.FEMALE)){sex = "ж";}
                    System.out.println(person.getName() + " " + sex + " " + dateFormat2.format(person.getBirthDate()));
                    break;
                }
            }

        //start here - начни тут
    }
}
