package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
regex matches() tellnumber
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        return telNumber != null
                && telNumber
                .matches("^(\\+(?=(\\D?\\d){12}$)|(?=(\\D?\\d){10}$))\\d*(\\(\\d{3}\\))?(\\d+-){0,2}\\d+$");
    }

    public static void main(String[] args) {
        String test =
                "+380501234567 - true\n" +
                        "+38(050)1234567 - true\n" +
                        "+38050123-45-67 - true\n" +
                        "050123-4567 - true\n" +
                        "+1234567890 - false\n" +
                        "+38)050(1234567 - false\n" +
                        "+38(050)1-23-45-6-7 - false\n" +
                        "050ххх4567 - false\n" +
                        "050123456 - false\n" +
                        "(0)501234567 - false";
        String[] words;
        boolean check;
        for (String s : test.split("\\n")) {
            words = s.split("\\s");
            check = checkTelNumber(words[0]);
            System.out.printf("%-30s\t%b\t%s%n", s, check, check == "true".equals(words[2]) ? "" : "!!!");
        }
    }
}
