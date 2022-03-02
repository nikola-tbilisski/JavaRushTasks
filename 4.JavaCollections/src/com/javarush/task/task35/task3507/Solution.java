package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/

public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Set<? extends Animal> allAnimals =
                getAllAnimals(Solution.class
                        .getProtectionDomain()
                        .getCodeSource()
                        .getLocation()
                        .getPath() + Solution.class
                        .getPackage()
                        .getName()
                        .replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws UnsupportedEncodingException {
        if (!pathToAnimals.endsWith("\\") && !pathToAnimals.endsWith("/"))
            pathToAnimals = pathToAnimals + "/";
        //System.out.println(pathToAnimals);
        Set<Animal> set = new HashSet<>();

        ClassLoader classLoader = new ClassLoader() {
            byte[] b;

            @Override
            protected Class<?> findClass(String name) {
                try {
                    b = Files.readAllBytes(Paths.get(name));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return defineClass(null, b, 0, b.length);
            }
        };

        File file = new File(URLDecoder.decode(pathToAnimals, "UTF-8"));
        FileFilter fileFilter = files -> files.isFile() && files.getName().endsWith(".class");
        File[] classFiles = file.listFiles(fileFilter);

        assert classFiles != null;
        //Arrays.stream(classFiles).forEach(System.out::println);


        try {
            for (File f : classFiles) {
                // System.out.println(f);

                Class<?> clazz = classLoader.loadClass(f.getAbsolutePath());
                if (Animal.class.isAssignableFrom(clazz)) {
//                        Constructor<?> constructor = clazz.getConstructor();
//                        constructor.setAccessible(true);
                    Constructor<?>[] constructors = clazz.getConstructors();
                    for (Constructor<?> con : constructors) {
                        if (con.getParameterTypes().length == 0) {
                            set.add((Animal) con.newInstance());
                        }
                    }

                }
            }
        } catch (ClassNotFoundException
                | InstantiationException
                | IllegalAccessException
                | InvocationTargetException e) {
            e.printStackTrace();
        }


        return set;
    }

//    public static byte[] fetchClasses(String pathToClasses) throws IOException {
//        File file = new File(pathToClasses);
//        FileFilter fileFilter = files -> files.isFile() && files.getName().endsWith(".class");
//        File[] classFiles = file.listFiles(fileFilter);
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//
//        System.out.println(Arrays.toString(file.listFiles(fileFilter)));
//        assert classFiles != null;
//        for(File f : classFiles){
//            bos.write(Files.readAllBytes(Paths.get(String.valueOf(f))));
//        }
//
//        for(byte b : bos.toByteArray()){
//            System.out.print((char) b);
//        }
//
//        return bos.toByteArray();
//    }

}
