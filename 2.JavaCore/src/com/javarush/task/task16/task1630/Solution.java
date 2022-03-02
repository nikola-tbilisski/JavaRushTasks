package com.javarush.task.task16.task1630;

import java.io.*;
import java.nio.charset.StandardCharsets;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static String firstFileName;
    public static String secondFileName;

    static {

        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //add your code here - добавьте код тут

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{
        private String fullFileName;
        private String fileContent = "";

        @Override
        public void run()
            {
                String ln;

                try(BufferedReader fileReader = new BufferedReader(new FileReader(fullFileName)) ){
                    while ((ln = fileReader.readLine()) != null){
                        fileContent += ln + " ";
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        @Override
        public void setFileName(String fullFileName)
            {
                this.fullFileName = fullFileName;
            }

        @Override
        public String getFileContent()
            {
                return fileContent;
            }
    }

    //add your code here - добавьте код тут
}
