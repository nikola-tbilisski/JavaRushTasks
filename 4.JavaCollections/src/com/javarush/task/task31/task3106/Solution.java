package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.zip.ZipInputStream;

/* 
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        File resultFile = new File(args[0]);
        if (!resultFile.exists()) resultFile.createNewFile();
        Set<String> zipFileSet = new TreeSet<>(Arrays.asList(args).subList(1, args.length));
        List<FileInputStream> fisList = new ArrayList<>();

        zipFileSet.forEach(System.out::println);

        for (String s : zipFileSet) {
            fisList.add(new FileInputStream(s));
        }

        try (ZipInputStream zis = new ZipInputStream(new SequenceInputStream(Collections.enumeration(fisList)));
             OutputStream os = new BufferedOutputStream(new FileOutputStream(resultFile))) {
            while (zis.getNextEntry() != null) {
                    final int bufSize = 1024;
                    byte[] buffer = new byte[bufSize];
                    int count;

                    while ((count = zis.read(buffer)) != -1){
                        os.write(buffer, 0, count);
                    }
                    os.flush();
            }
        }

    }
}
