package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Только по-очереди!
*/

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    //public static volatile AtomicInteger strCounter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        t1.start();
        t1.join();



        t2.start();
        t2.join();
        //add your code here - добавьте код тут

        t1.printResult();
        t2.printResult();
    }

        public static class Read3Strings extends Thread{
            //int counter = 0;
           // List<String> list = new ArrayList<>();
            //String res = null;
            String[] strAr = new String[3];

            @Override
            public void run()
                {
                    for(int i = 0; i < strAr.length; i ++){
                        try {
                            strAr[i] = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                   /* while (!(Thread.currentThread().isInterrupted())){
                        try {
                                list.add(reader.readLine());
                                counter++;
                                if(counter == 3){
                                   Thread.currentThread().interrupt();
                                }


                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }*/

                }
                public void printResult(){
                    System.out.println(strAr[0] + " " + strAr[1] + " " + strAr[2]);
                    /*for(String s : list){
                        System.out.print(s + " ");
                    }
                    System.out.println();*/
                }
        }
    //add your code here - добавьте код тут
}
