package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
//algorithm square

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}
        };
        byte[][] a2 = new byte[][]{
                {1, 1, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 1, 1},
                {1, 0, 1, 1}
        };

        // System.out.println(a1[3][0]);

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int rect = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (((a[i][j] == 1) && ((j == 0) || (a[i][j - 1] == 0))) && ((i == 0) || (a[i - 1][j] == 0))) {
                    rect++;
                }
            }
        }
        //System.out.println(rect);
        return rect;
    }
}
