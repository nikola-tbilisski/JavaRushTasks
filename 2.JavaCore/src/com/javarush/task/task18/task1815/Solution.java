package com.javarush.task.task18.task1815;

import java.util.List;
import java.util.Locale;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface {
         TableInterface ob;

        public TableInterfaceWrapper(TableInterface ob){
            this.ob = ob;
        }

        @Override
        public void setModel(List rows)
            {
                System.out.println(rows.size());
                ob.setModel(rows);
            }

        @Override
        public String getHeaderText()
            {
                return ob.getHeaderText().toUpperCase();
            }

        @Override
        public void setHeaderText(String newHeaderText)
            {
                ob.setHeaderText(newHeaderText);
            }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}