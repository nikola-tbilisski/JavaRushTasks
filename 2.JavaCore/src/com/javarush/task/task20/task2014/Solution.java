package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable {
    public static void main(String[] args) {
        try {
            File myFile = File.createTempFile("task2014",".log");
            OutputStream outputStream = new FileOutputStream(myFile);
            InputStream inputStream = new FileInputStream(myFile);

            Solution savedObject = new Solution(36);

            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(savedObject);
            oos.flush();

            Solution loadedObject = new Solution(45);
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            loadedObject = (Solution) ois.readObject();

            System.out.println(savedObject.string.equals(loadedObject.string));

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(new Solution(4));
    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
