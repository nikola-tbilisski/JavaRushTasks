package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());

        if(x <= 0 || y <= 0)
            throw new Exception();
        else System.out.println(mCM(x, y));


    }
    private static int mCM(int x, int y){
        while(x!=0 && y!=0){
            if (x>y) x=x%y;
            else y=y%x;
        }
       return x + y;
    }
}
