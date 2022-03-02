package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File rootFolder = new File(root);
        List<String> tempFileTree = new ArrayList<>();
        Queue<File> fileQueue = new LinkedList<>(Arrays.asList(Objects.requireNonNull(rootFolder.listFiles())));

        while (!fileQueue.isEmpty()) {
            File filePoll = fileQueue.poll();
            if (filePoll.isFile()) {
                tempFileTree.add(filePoll.getAbsolutePath());
            } else {
                for (File f : Objects.requireNonNull(filePoll.listFiles())) {
                    if (f.isFile()) {
                        tempFileTree.add(f.getAbsolutePath());
                    } else fileQueue.add(f);
                }
            }
        }

//        for(File files : Objects.requireNonNull(rootFolder.listFiles())){
//            if(files.isFile()){
//                tempFileTree.add(files.getAbsolutePath());
//            } else if(files.isDirectory()){
//                for(File subFiles : Objects.requireNonNull(files.listFiles())){
//                    tempFileTree.add(subFiles.getAbsolutePath());
//                }
//            }
//        }

        return tempFileTree;

    }

    public static void main(String[] args) {
        try {
            for (String s : getFileTree("c:/temp")) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
