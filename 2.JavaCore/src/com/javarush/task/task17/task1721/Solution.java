package com.javarush.task.task17.task1721;

import javax.smartcardio.ATR;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static String file1;
    public static String file2;

    static {
        try {
            file1 = reader.readLine();
            file2 = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader allLineReader = new BufferedReader(new FileReader(file1));
            while (allLineReader.ready()){
                allLines.add(allLineReader.readLine());
            }
            allLineReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader frlReader = new BufferedReader(new FileReader(file2));
            while (frlReader.ready()){
                forRemoveLines.add(frlReader.readLine());
            }
            frlReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Solution sol = new Solution();
            sol.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }

    }

    public void joinData() throws CorruptedDataException
        {

        //Collections.sort(allLines);
        //Collections.sort(forRemoveLines);

        if(allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }   else {
            allLines.clear();
            throw new CorruptedDataException();
        }

      /*  for(String s: allLines)
            System.out.println(s);

        System.out.println();

        for (String s: forRemoveLines)
            System.out.println(s);*/


    }
}
