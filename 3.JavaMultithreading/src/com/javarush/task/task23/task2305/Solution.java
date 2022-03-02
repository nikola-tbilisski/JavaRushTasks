package com.javarush.task.task23.task2305;

/* 
Inner
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
       Solution[] sol = new Solution[2];

       for(int i = 0; i < sol.length; i++){
           sol[i] = new Solution();
           sol[i].innerClasses[0] = sol[i].new InnerClass();
           sol[i].innerClasses[1] = sol[i].new InnerClass();
       }

        return sol;
    }

    public static void main(String[] args) {

    }
}
