package com.javarush.task.task16.task1613;

/* 
Big Ben clock
*/

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Solution {
    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock("Лондон", 23, 59, 57);
        Thread.sleep(4000);
        isStopped = true;
        Thread.sleep(1000);
    }

    public static class Clock extends Thread {
        private String cityName;
        private int hours;
        private int minutes;
        private int seconds;

        public Clock(String cityName, int hours, int minutes, int seconds) {
            this.cityName = cityName;
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            start();
        }

        public void run() {
            try {
                while (!isStopped) {
                    printTime();
                }
            } catch (InterruptedException | ParseException e) {
            }
        }

        private void printTime() throws InterruptedException, ParseException
            {
            String strDate = hours + ":" + minutes + ":" + seconds;
           // System.out.println(strDate);
                Thread.sleep(1000);
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date date = dateFormat.parse(strDate);
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                cal.add(Calendar.SECOND, 1);
                seconds = cal.get(Calendar.SECOND);
                minutes = cal.get(Calendar.MINUTE);
                hours = cal.get(Calendar.HOUR_OF_DAY);


                //System.out.println(cal.getTime());
            //add your code here - добавь код тут

            if (hours == 0 && minutes == 0 && seconds == 0) {
                System.out.println(String.format("В г. %s сейчас полночь!", cityName));
            } else {
                System.out.println(String.format("В г. %s сейчас %d:%d:%d!", cityName, hours, minutes, seconds));
            }
        }
    }
}
