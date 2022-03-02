package com.javarush.task.task17.task1703;

import java.util.ArrayList;
import java.util.List;

/* 
Синхронизированные заметки
*/

public class Solution {

    public static void main(String[] args) {
        Note note1 = new Note();
        note1.start();

        Note note2 = new Note();
        note2.start();

    }

    public static class Note extends Thread {

        public final List<String> notes = new ArrayList<String>();

        @Override
        public void run()
            {
                addNote(0, "პირველი ვარ შეჩემა");
                removeNote(0);
            }

        public void addNote(int index, String note) {
            System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index +
                    "in thread" + Thread.currentThread().getName());
            synchronized (notes) { notes.add(index, note); }
            //notes.add(index, note);
            System.out.println("Уже добавлена заметка [" + note + "]");
        }

        public void removeNote(int index) {
            String note;
            System.out.println("Сейчас будет удалена заметка с позиции " + index +
                    "in thread" + Thread.currentThread().getName());
            synchronized (notes){
                note =  notes.remove(index);
            }
            System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);

        }
    }

}
