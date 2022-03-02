package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Нити и байты
*/
//Map HashMap + Thread + List ArrayList(calculate maximum occurrence of byte symbol in byte[] array

public class Solution {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static List<String> fileNameList = new ArrayList<>();
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
        {
        String str;

        while (!(str = reader.readLine()).equals("exit")){
            fileNameList.add(str);
        }
        reader.close();

        try {
            for(String s: fileNameList){
                new ReadThread(s).start();
            }

        } catch (Exception e){e.printStackTrace();}

          /*  for(Map.Entry<String, Integer> hashMap: resultMap.entrySet()){
                System.out.println(hashMap.getKey() + " " + hashMap.getValue());
            }*/

    }

    public static class ReadThread extends Thread {
        BufferedInputStream stream;
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
            //implement constructor body
        }

                @Override
                public void run()
                {
                    try {
                        stream = new BufferedInputStream(new FileInputStream(fileName));
                        byte[] buffer = new byte[stream.available()];

                        while (stream.available() > 0){
                                stream.read(buffer);
                         }
                        int byteCount, maxCount = 0;
                        int myByte = 0;
                        for(byte b1: buffer){
                            byteCount = 0;
                            for(byte b2: buffer){
                                if(b1 == b2) byteCount++;
                                if(byteCount > maxCount){
                                    maxCount = byteCount;
                                    myByte = b1;
                                }
                            }
                        }
                        if(!resultMap.containsKey(fileName)){
                            resultMap.put(fileName, myByte);
                            System.out.println(fileName + " " + myByte);
                        }
                        //System.out.println(maxCount + " " + myByte);
                    } catch (IOException e) {
                            e.printStackTrace();
                        }
                    finally {
                        try {
                            stream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
