package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/
//class Adapter + Scanner + SimpleDateFormat
public class Solution {

    public static void main(String[] args) throws IOException, ParseException
        {
        PersonScanner personScanner = new PersonScannerAdapter(new Scanner(new File("c:/temp/test.txt")));
        Person person = personScanner.read();
            System.out.println(person);
            personScanner.close();


    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        @Override
        public Person read() throws IOException, ParseException
            {
                String[] person = fileScanner.nextLine().split(" ", 4);
                SimpleDateFormat dateFormat = new SimpleDateFormat("d M y", Locale.ENGLISH);
                String d = person[3];
                String middleN = person[2];
                String firstN = person[1];
                String lastN = person[0];
                Date date = dateFormat.parse(d);

                return new Person(firstN, middleN, lastN, date);
            }

        @Override
        public void close() throws IOException
            {
                fileScanner.close();
            }

        public PersonScannerAdapter(Scanner fileScanner)
            {
                this.fileScanner = fileScanner;
            }
    }
}
