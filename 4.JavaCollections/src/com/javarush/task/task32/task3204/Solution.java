package com.javarush.task.task32.task3204;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

/* 
Генератор паролей
*/

public class Solution {
    private static final String LOWERCASE_CHAR = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHAR = LOWERCASE_CHAR.toUpperCase();
    private static final String DIGIT = "0123456789";
    private static final int PASS_LENGTH = 8;
    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password);
    }

    public static ByteArrayOutputStream getPassword() {
        String password;
        StringBuilder result = new StringBuilder(PASS_LENGTH);

        String lowerCase = generateRendStr(LOWERCASE_CHAR, 3);
        result.append(lowerCase);

        String upperCase = generateRendStr(UPPERCASE_CHAR, 3);
        result.append(upperCase);

        String digits = generateRendStr(DIGIT, 2);
        result.append(digits);

        password = result.toString();
        ByteArrayOutputStream bAoS = new ByteArrayOutputStream();

        try(BufferedInputStream bis = new BufferedInputStream(new ByteArrayInputStream(password.getBytes(StandardCharsets.UTF_8)))) {

            while (bis.available() > 0){
                int data = bis.read();
                bAoS.write(data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return bAoS;
    }

    public static String generateRendStr(String input, int size){
        if(input == null || size <= 0) {
            throw new IllegalArgumentException("Please try again");
        }
        StringBuilder result = new StringBuilder(size);

        for(int i = 0; i < size; i++){
            int index = random.nextInt(input.length());
            result.append(input.charAt(index));
        }

        return result.toString();
    }
}
