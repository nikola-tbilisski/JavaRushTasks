package com.javarush.task.task20.task2024;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
*/

public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

    public static void main(String[] args) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("task2024.txt"));
            Solution sol1 = new Solution();
            sol1.node = 33;

            for(int i = 0; i < 10; i++) {
                sol1.edges.add(new Solution());
            }

            oos.writeObject(sol1);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("task2024.txt"));
            Solution sol2 = new Solution();

            sol2 = (Solution) ois.readObject();
            ois.close();
            System.out.println(sol2.equals(sol1));
            System.out.println(sol2.node);
            for(Solution sol: sol2.edges){
                System.out.println(sol.getClass());
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
