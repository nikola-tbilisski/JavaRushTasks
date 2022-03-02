package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
        public static void main(String[] args) throws Exception {
            if (args.length != 0 && args[0].equals("-c")) // проверка на наличие аргументов и первого аргумента
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String fileName = reader.readLine();
                reader.close();
                BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
                List<Integer> list = new ArrayList<>();
                while (fileReader.ready()) { //запись интерегера преобразованного из первых восьми символов каждой строки
                    list.add(Integer.parseInt(fileReader.readLine().substring(0, 8).trim()));
                }

                int maxID = Collections.max(list); //выбираю максимальный ID`
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true)); //поток записи с ДОзаписью
                writer.write(String.format("\n%-8s%-30s%-8s%-4s", ++maxID, args[1], args[2], args[3])); // новая строка и для каждого параметра нужное количество символов
                fileReader.close();
                writer.close();
            }
            else return;


        }

}
