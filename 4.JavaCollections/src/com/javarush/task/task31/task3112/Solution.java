package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords =
                downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        String fileName = urlString.substring(urlString.lastIndexOf("/"));
        System.out.println(fileName);
        URL url = new URL(urlString);
        Path result = null;
        try(InputStream urlInputStream = url.openStream()) {
            Path tmpFile = Files.createTempFile("javarushTMP", ".tmp");
            Files.copy(urlInputStream, tmpFile, StandardCopyOption.REPLACE_EXISTING);
            if(Files.notExists(downloadDirectory)) Files.createDirectory(downloadDirectory);
            result = Files.move(tmpFile, Paths.get(downloadDirectory + fileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
        // implement this method
    }
}
