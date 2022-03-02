package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/

public class Solution {
    private static volatile int folderCount = -1;
    private static volatile int fileCount = 0;
    private static volatile long folderSize = 0;

//    private static final AtomicInteger folderCount = new AtomicInteger(-1);
//    private static final AtomicInteger fileCount = new AtomicInteger(0);
//    private static final AtomicLong folderSize = new AtomicLong(0);
    //private static final AtomicInteger folderSize = new AtomicInteger(0);
    //private static volatile int folderSize;

    public static void main(String[] args) throws IOException {
//        final int folderCounter;
//        final int fileCounter;
//        final int[] fileCount = {0};
//        final int[] folderCount = {-1};
        String folderPathStr;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            folderPathStr = reader.readLine();
            Path pathToFolder = Paths.get(folderPathStr);

//            if (Files.notExists(pathToFolder)) {
//                //System.out.println("No such directory, please try again.");
//                return;
//            }

            if (!Files.isDirectory(pathToFolder)) {
                System.out.println(pathToFolder + " - не папка");
                return;
            }

            Files.walkFileTree(pathToFolder, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    if (Files.isDirectory(dir)) folderCount++;

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (attrs.isRegularFile()) fileCount++;
                    folderSize += attrs.size();

                    return FileVisitResult.CONTINUE;
                }
            });
            System.out.println("Всего папок - " + folderCount + "\n" +
                    "Всего файлов - " + fileCount + "\n" +
                    "Общий размер - " + folderSize);
        }
    }
}
