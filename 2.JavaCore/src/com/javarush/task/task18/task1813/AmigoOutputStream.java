package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    FileOutputStream ob;

    public AmigoOutputStream(FileOutputStream ob) throws FileNotFoundException {
        super(fileName);
        this.ob = ob;
    }

    @Override
    public void write(int b) throws IOException
        {
            ob.write(b);
        }

    @Override
    public void write(byte[] b) throws IOException
        {
            ob.write(b);
        }

    @Override
    public void write(byte[] b, int off, int len) throws IOException
        {
            ob.write(b, off, len);
        }

    @Override
    public void close() throws IOException
        {
            ob.flush();
            write("JavaRush © All rights reserved.".getBytes());
            ob.close();
        }

    @Override
    public void flush() throws IOException
        {
            ob.flush();
        }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
