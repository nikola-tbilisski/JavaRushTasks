package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filepath1, filepath2, filepath3;
        filepath1 = reader.readLine();
        filepath2 = reader.readLine();
        filepath3 = reader.readLine();

        BufferedInputStream fileInput = new BufferedInputStream(new FileInputStream(filepath1));
        BufferedOutputStream file2Output = new BufferedOutputStream(new FileOutputStream(filepath2));
        BufferedOutputStream file3Output = new BufferedOutputStream(new FileOutputStream(filepath3));
        int fileCap = fileInput.available();
        int bytesOdd = (fileCap/2) + (fileCap % 2);
        byte[] buffer = new byte[fileCap];


            while (fileInput.available() > 0){
                int count = fileInput.read(buffer);
                if(fileCap % 2 != 0) {
                    file2Output.write(buffer, 0, bytesOdd);
                    file3Output.write(buffer, bytesOdd, fileCap - bytesOdd);
                }
                else {
                    file2Output.write(buffer, 0, count/2);
                    file3Output.write(buffer, count/2, fileCap - count/2);
                }
            }

        fileInput.close();
        file2Output.close();
        file3Output.close();



       // System.out.println(fileCap);
       // System.out.println(bytesOdd);

    }
}
