package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/
//ArrayDeque add 2 string combination to one string

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static ArrayDeque<String> file1Deq = new ArrayDeque<>();
    public static ArrayDeque<String> file2Deq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1Path = reader.readLine(), file2Path = reader.readLine();
        reader.close();

        BufferedReader file1Reader = new BufferedReader(new FileReader(file1Path));
        BufferedReader file2Reader = new BufferedReader(new FileReader(file2Path));

        while (file1Reader.ready()){
            file1Deq.add(file1Reader.readLine());
        }
        file1Reader.close();

        while (file2Reader.ready()){
            file2Deq.add(file2Reader.readLine());
        }
        file2Reader.close();



        while (file1Deq.size() > 0 && file2Deq.size() > 0){
                if(file1Deq.peekFirst().equals(file2Deq.peekFirst())){
                    lines.add(new LineItem(Type.SAME, file1Deq.pollFirst()));
                    file2Deq.pollFirst();
                    //break;
                }

                else if(!(file1Deq.peekFirst().equals(file2Deq.peekFirst()))){
                    String file1DeqFE = file1Deq.pollFirst();
                    if (file1Deq.peekFirst() != null && file2Deq.peekFirst() != null) {
                        if(file1Deq.peekFirst().equals(file2Deq.peekFirst())){
                            lines.add(new LineItem(Type.REMOVED, file1DeqFE));
                        }
                        else if(!(file1Deq.peekFirst().equals(file2Deq.peekFirst()))){
                            file1Deq.push(file1DeqFE);
                            lines.add(new LineItem(Type.ADDED, file2Deq.pollFirst()));
                        }
                    }
                }
        }
        while (file1Deq.peek() != null) {
            lines.add(new LineItem(Type.REMOVED, file1Deq.pollFirst()));
        }

        while (file2Deq.peek() != null) {
            lines.add(new LineItem(Type.ADDED, file2Deq.pollFirst()));
        }

        for (LineItem li: lines){
            System.out.println(li);
        }

       /* while (file1Deq.peek() != null){
            System.out.println("file1Dec"+file1Deq.poll());
        }
            System.out.println();

        while (file2Deq.peek() != null){
            System.out.println("file2.Dec"+file2Deq.poll());
        }*/

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
        @Override
        public String toString()
            {
                return type + " " + line;
            }
    }

}
