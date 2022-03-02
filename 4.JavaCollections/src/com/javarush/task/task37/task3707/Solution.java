package com.javarush.task.task37.task3707;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        AmigoSet<String> amigoSet = new AmigoSet<>();
        for (int i = 0; i < 10; i++)
            amigoSet.add("number" + i);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(baos);
        outputStream.writeObject(amigoSet);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream inputStream = new ObjectInputStream(bais);
        AmigoSet<String> newAmigo = (AmigoSet<String>) inputStream.readObject();

        System.out.println(amigoSet.size() + " " + newAmigo.size());
        for (String i : newAmigo)
            System.out.println(i);
    }
}
