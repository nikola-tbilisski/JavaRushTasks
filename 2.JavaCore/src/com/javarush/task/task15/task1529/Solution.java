package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(result.getClass().getSimpleName());

    }

    static {
        try {
            reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //add your code here - добавьте код тут
    }

    public static CanFly result;

    public static void reset() throws IOException
        {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String veSsl = reader.readLine();
        if(veSsl.equals("helicopter")){
            result = new Helicopter();
        }
        else if(veSsl.equals("plane")){
            result = new Plane(380);
        }
        //add your code here - добавьте код тут
    }
}
