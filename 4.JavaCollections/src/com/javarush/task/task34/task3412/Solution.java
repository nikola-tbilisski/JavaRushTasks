package com.javarush.task.task34.task3412;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Properties;

/* 
Добавление логирования в класс
*/

public class Solution {
    private static final Logger logger = LoggerFactory.getLogger(Solution.class);

    private int value1;
    private String value2;
    private Date value3;

    public Solution(int value1, String value2, Date value3) {
        logger.debug("Constructor: value1 = "+value1+" value2 = "+value2+" value3 = "+value3);
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public static void main(String[] args) {
        String logProperties = "4.JavaCollections/src/"
                + com.javarush.task.task34.task3412.Solution.class.getPackage().getName().replaceAll("[.]", "/")
                + "/log4j.properties";
        PropertyConfigurator.configure(logProperties);

        Path path = Paths.get(logProperties).toAbsolutePath();
        try (InputStream is = new FileInputStream(path.toFile())) {
            Properties properties = new Properties();
            properties.load(is);
            System.out.println("See detailed log in file: " + properties.getProperty("log4j.appender.file.File"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nLOG STARTED");
        System.out.println("=====================");
        Solution solution = new Solution(85, "Bulat", new Date());
        solution.calculateAndSetValue3(5555L);
        solution.printString();
        solution.printDateAsLong();
        solution.divide(10, 5);
        solution.divide(10, 0);
        solution.setValue1(666);
        solution.setValue2("Kekeke");
        solution.setValue3(new Date());

    }

    public void calculateAndSetValue3(long value) {
        logger.trace("calculateAndSetValue3 "+value);
        value -= 133;
        if (value > Integer.MAX_VALUE) {
            value1 = (int) (value / Integer.MAX_VALUE);
            logger.debug("calculateAndSetValue3 -> value > Integer.MAX_VALUE -> value1 = "+value1);
        } else {
            value1 = (int) value;
            logger.debug("calculateAndSetValue3 -> value < Integer.MAX_VALUE -> value1 = "+value1);
        }
    }

    public void printString() {
        logger.trace("printString");
        if (value2 != null) {
            System.out.println(value2.length());
        }
    }

    public void printDateAsLong() {
        logger.trace("printDateAsLong");
        if (value3 != null) {
            System.out.println(value3.getTime());
        }
    }

    public void divide(int number1, int number2) {
        logger.trace("divide: number1 = " + number1 + ", number2 = " + number2);
        try {
            System.out.println(number1 / number2);
        } catch (ArithmeticException e) {
            logger.error("ArithmeticException: number1 = " + number1 + ", number2 = " + number2, e);
        }
    }

    public void setValue1(int value1) {
        logger.debug("setValue1: value1 = "+value1);
        this.value1 = value1;
    }

    public void setValue2(String value2) {
        logger.debug("setValue2: value2 = "+value2);
        this.value2 = value2;
    }

    public void setValue3(Date value3) {
        logger.debug("setValue3: value3 = "+value3);
        this.value3 = value3;
    }
}
