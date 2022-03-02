package com.javarush.task.task20.task2004;

import java.io.*;

/* 
Читаем и пишем в файл статики
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File yourFile = File.createTempFile("task2004", ".txt");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 3;
            classWithStatic.j = 4;
            classWithStatic.save(outputStream);
            outputStream.flush();

            ClassWithStatic loadedObject = new ClassWithStatic();
            ClassWithStatic.staticString = "something";
            loadedObject.i = 6;
            loadedObject.j = 7;

            loadedObject.load(inputStream);
            System.out.println(classWithStatic.equals(loadedObject));
            System.out.println("loadedObject Ob: "+loadedObject);
            System.out.println("classWithStatic Ob: "+classWithStatic);
            //here check that the classWithStatic object is equal to the loadedObject object - проверьте тут, что classWithStatic и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class ClassWithStatic {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;

        public void save(OutputStream outputStream) {
            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert oos != null;
                oos.writeObject(this.i);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                oos.writeObject(this.j);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                oos.writeObject(staticString);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert ois != null;
                i = (int) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                j = (int) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                staticString = (String) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            //implement this method - реализуйте этот метод
        }

        @Override
        public String toString()
            {
                return staticString + " " + i + " " + j;
            }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ClassWithStatic that = (ClassWithStatic) o;

            if (i != that.i) return false;
            return j == that.j;

        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }
}
