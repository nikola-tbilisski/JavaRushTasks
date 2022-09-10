package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/
//regular expression SimpleDateFormat
public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException
        {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        //Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
        String lines;

        while ((lines = fileReader.readLine()) != null){
            String name = lines.replaceAll("\\s*\\d+\\s*", "");
            Date date = dateFormat.parse(lines.replaceAll("\\D+\\s+", ""));
            //System.out.println(name);
            PEOPLE.add(new Person(name, date));
        }
        fileReader.close();

        for(Person p: PEOPLE){
            System.out.println(p.getName() +  " " + p.getBirthDate());
        }

    }
}
