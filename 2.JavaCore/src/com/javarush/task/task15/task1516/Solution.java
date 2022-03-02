package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

public class Solution {

        public int intVar;
        public double doubleVar;
        public Double DoubleVar;
        public boolean booleanVar;
        public Object ObjectVar;
        public Exception ExceptionVar;
        public String StringVar;

       // public void print(){System.out.println(intVar+"\n"+doubleVar+"\n"+DoubleVar+"\n"+booleanVar+"\n"+objectVar+"\n"+ExceptionVar+"\n"+StringVar);}


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.intVar+"\n"+sol.doubleVar+"\n"+sol.DoubleVar+"\n"+sol.booleanVar+"\n"+sol.ObjectVar+"\n"+sol.ExceptionVar+"\n"+sol.StringVar);
    }
}
