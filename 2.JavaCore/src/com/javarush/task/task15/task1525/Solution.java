package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static Reader input;

    static {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Statics.FILE_NAME));
            //int data = input.read();
            while (reader.ready()){
                //System.out.print((char) data);
                Solution.lines.add(reader.readLine());
                //data = input.read();
                //Solution.lines.add(String.valueOf((char) data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
       /* for(String s: lines){
            System.out.println(s);
        }*/
    }
}
