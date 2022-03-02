package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/*
Собираем файл
*/
// Buffered reader + BufferedInputStream + BufferedOutputStream + HashMap + substring() + replaceAll() "Add little files to main file"
public class Solution
    {
        public static void main(String[] args) throws IOException
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                Map<Integer, String> filePartsMap = new HashMap<>();
                String str;
                BufferedInputStream fileInputStream;
                byte[] buffer;
                BufferedOutputStream fileOutputStream;


                while (!( str = reader.readLine() ).equalsIgnoreCase("end")) {
                    String s2 = str.substring(str.lastIndexOf("part"));	//extracts file name to add to main file
                    filePartsMap.put(extractInt(s2), str);
                }
                reader.close();

                for(Map.Entry<Integer, String> entry: filePartsMap.entrySet())
                {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                    fileInputStream = new BufferedInputStream(new FileInputStream(entry.getValue()));
                    buffer = new byte[fileInputStream.available()];

                    while (fileInputStream.available() > 0){
                        fileInputStream.read(buffer);
                    }
                    fileInputStream.close();

                    fileOutputStream = new BufferedOutputStream(new FileOutputStream(entry.getValue().substring(0, entry.getValue().lastIndexOf(".part")), true));
                    fileOutputStream.write(buffer);

                    fileOutputStream.close();
                }

            }

        public static int extractInt(String str)
            {
                str = str.replaceAll("[^\\d]", " ");
                str = str.trim();
                str = str.replaceAll(" +", " ");
                if(str.equals("")) return -1;

                return Integer.parseInt(str);
            }
    }
