package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
        //allPeople.add(Person.createFemale("Жанна Коппес", new Date()));
    }

    public static void main(String[] args) throws ParseException {
            switch (args[0])
            {
                case "-c": {
                    synchronized (allPeople){addPersons(args);};
                    break;
                }

                case "-u": {
                    synchronized (allPeople){updatePersons(args);}
                    break;
                }

                case "-d": {
                    synchronized (allPeople){deletePersons(args);}
                    break;
                }

                case "-i": {
                    synchronized (allPeople){printPersons(args);}
                }
                break;
            }
        //start here - начни тут
    }
    private static void addPersons(String[] args) throws ParseException
        {
            Person person;
            for(int i = 1; i < args.length; i++){
            String personName = args[i];
            String personSex = args[++i];
            String personBD = args[++i];
            person = personSex.equals("м")? Person.createMale(personName, dateFormat1.parse(personBD)):
                    Person.createFemale(personName, dateFormat1.parse(personBD));
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        }
    }
    private static void updatePersons(String[] args) throws ParseException
        {
            Person person;
            System.out.println(allPeople.size());
            for(int i = 1; i < args.length; i += 4){
                int personIndex = Integer.parseInt(args[i]);
                String personName = args[i+1];
                String personSex = args[i+2];
                Date personDB = dateFormat1.parse(args[i+3]);
                person = personSex.equals("м")? Person.createMale(personName, personDB):
                        Person.createFemale(personName, personDB);
                allPeople.set(personIndex, person);
               System.out.println(allPeople.size() + " " + allPeople.indexOf(person));
               //i = 0;

            }
        }

        private static void deletePersons(String[] args)
            {
                Person person;

                for(int i = 1; i < args.length; i++){
                    int personIndex = Integer.parseInt(args[i]);

                    person = allPeople.get(personIndex);
                    person.setName(null);
                    person.setSex(null);
                    person.setBirthDate(null);
                }
            }

        private static void printPersons(String[] args) throws ParseException
            {
                Person person;
                for(int i = 1; i < args.length; i++){
                    int personIndex = Integer.parseInt(args[i]);
                    person = allPeople.get(personIndex);
                    String personSex = person.getSex() == Sex.MALE? "м": "ж";
                    Date personBD = person.getBirthDate();
                    System.out.println(person.getName() + " " + personSex + " " + dateFormat2.format(personBD));
                }
            }
}
