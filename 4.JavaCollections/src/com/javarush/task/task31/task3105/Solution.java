package com.javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<ZipEntry, ByteArrayOutputStream> hashMap = new HashMap<>();
        byte[] buffer = new byte[1024];

        try (ZipInputStream archiveZis = new ZipInputStream(new FileInputStream(args[1]))) {

            ZipEntry zipEntry;
            ByteArrayOutputStream baOS;

            while ((zipEntry = archiveZis.getNextEntry()) != null) {
                baOS = new ByteArrayOutputStream();
                int count;
                while ((count = archiveZis.read(buffer)) > -1) {
                    baOS.write(buffer, 0, count);
                }
                hashMap.put(zipEntry, baOS);

                archiveZis.closeEntry();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(args[1]))) {
            boolean fileExists = false;
            //System.out.println();

            for (Map.Entry<ZipEntry, ByteArrayOutputStream> entry : hashMap.entrySet()) {
                if (!String.valueOf(Paths.get(entry.getKey().toString()).getFileName()).equals(Paths.get(args[0]).getFileName().toString())) {
                    zos.putNextEntry(new ZipEntry(entry.getKey().toString()));
                    System.out.println("first if " + entry.getKey());
                    zos.write(entry.getValue().toByteArray(), 0, entry.getValue().toByteArray().length);
                    zos.closeEntry();
                } else {
                    zos.putNextEntry(new ZipEntry(entry.getKey().toString()));
                    System.out.println("Else: " + entry.getKey());
                    Files.copy(Paths.get(args[0]), zos);
                    zos.closeEntry();
                    fileExists = true;
                }

            }
            if (!fileExists) {
                zos.putNextEntry(new ZipEntry("new/" + Paths.get(args[0]).getFileName()));
                Files.copy(Paths.get(args[0]), zos);
                zos.closeEntry();
            }

        }
    }
}
