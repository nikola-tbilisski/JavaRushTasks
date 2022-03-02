package com.javarush.task.task18.task1828;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/* 
Прайсы 2
*/

public class Solution
    {
        public static void main(String[] args) throws IOException
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String fileName = reader.readLine();
                reader.close();
                BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
                // BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
                List<String> productList = new ArrayList<>();

                String currentLine;
                while ((currentLine = fileReader.readLine()) != null) {
                    productList.add(currentLine);
                }
                fileReader.close();


                for (String s : productList) {
                    System.out.println(s);
                }
                System.out.println();

                switch (args[0])
                {

                    case "-d": {
                        for (int i = 0; i < productList.size(); i++) {
                            if (Integer.parseInt(productList.get(i).substring(0, 8).trim()) == Integer.parseInt(args[1])) {
                                productList.remove(i);
                            }
                        }
                        for (String s : productList) {
                            System.out.println(s);
                        }
                        break;
                    }


                    case "-u": {
                        for(int i = 0; i < productList.size(); i++){
                            if(Integer.parseInt(productList.get(i).substring(0,8).trim()) == Integer.parseInt(args[1])){
                                productList.set(i, String.format("%-8s%-30.30s%-8.8s%-4.4s", args[1], args[2], args[3], args[4]));
                            }
                        }
                        System.out.println();
                        for (String s : productList) {
                            System.out.println(s);
                        }
                        break;
                    }


                    default:
                        break;
                }

                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
                for(String s: productList){
                    fileWriter.write(s + System.lineSeparator());
                }
                fileWriter.close();
            }
    }