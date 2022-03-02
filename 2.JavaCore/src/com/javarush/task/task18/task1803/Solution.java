package com.javarush.task.task18.task1803;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        BufferedInputStream readFile = new BufferedInputStream(new FileInputStream(filePath));
        int[] arr = new int[readFile.available()];
        //System.out.println(readFile.available());

        for(int i = 0; i < arr.length; i++){
                arr[i] = readFile.read();
                //System.out.println(arr[i]);
        }
        readFile.close();

        repNumbs(arr);
    }

    public static void repNumbs(int[] array){
        int max = Integer.MIN_VALUE;
        int maxDup = 0;
        //System.out.println(max);

        for(int i = 0; i < array.length; i++)
        {
            if(array[i] > max) max = array[i];
        }

        int[] arrayCalc = new int[max + 1];
        //System.out.println();

        for(int i = 0; i < array.length; i++)
        {
            arrayCalc[array[i]]++;
        }
        //System.out.println();

        for(int i =0; i <= max; i++)
        {
            if(arrayCalc[i] > maxDup) maxDup = arrayCalc[i];
            //if(arrayCalc[i] > 1) System.out.println(i + "-" + arrayCalc[i]);
        }

        for(int i = 0; i <= max; i++)
            if(arrayCalc[i] == maxDup) System.out.print(i + " ");

    }
}
