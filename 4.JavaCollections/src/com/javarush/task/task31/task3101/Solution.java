package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Set<File> fileList = new TreeSet<>(Comparator.comparing(File::getName));
        String folderString = args[0];
        String resultString = args[1];

        File file = new File(resultString);
        File folder = new File(folderString);
        File newFile = new File(file.getParent() + "/allFilesContent.txt");

            //System.out.println(resultString.getParentFile());
            if(FileUtils.isExist(newFile)){
                FileUtils.deleteFile(newFile);
            }
            FileUtils.renameFile(file, newFile);

        Files.walkFileTree(Paths.get(folderString), new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path folderPath, BasicFileAttributes attrs) throws IOException {
                File myFiles = new File(String.valueOf(folderPath));
                //System.out.println(myFiles.length());
                if(folder.isDirectory() && myFiles.length() <= 50){
                    //System.out.println(myFiles.getName() + " " + myFiles.length());
                    fileList.add(myFiles);
                }

                return super.visitFile(folderPath, attrs);
            }
        });
        //fileList.sort(Comparator.comparing(File::getName));

        for(File f : fileList){
            System.out.println(f.getName() + " " + f.length());
        }



            try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter(newFile, true))) {
                for(File f : fileList){
                    try(BufferedReader reader = new BufferedReader(new FileReader(f));) {
                        while (reader.ready()){
                            fileWriter.write(reader.readLine());
                            fileWriter.write("\n");
                        }
                    }
                }
            }

    }
}
