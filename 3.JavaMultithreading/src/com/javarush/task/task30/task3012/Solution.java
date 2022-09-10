package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        int[] arrOfNum = {1, 3, 9, 27, 81, 243, 729, 2187};
        StringBuilder stringBuilder = new StringBuilder(number + " =");

        for (int j : arrOfNum) {
            if (number % 3 == 1) {
                stringBuilder.append(" + ").append(j);
            } else if (number % 3 == 2) {
                stringBuilder.append(" - ").append(j);
                number += 1;
            }
            number /= 3;
        }

        System.out.println(stringBuilder);

        //напишите тут ваш код
    }
}