package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/

public class Solution {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException {
        System.out.println(getExpectedClass());
    }

    public static Class<?> getExpectedClass() throws IllegalAccessException, InstantiationException {
        Class<?>[] clazzArr = Collections.class.getDeclaredClasses();

        for (Class<?> aClass : clazzArr) {
            if (List.class.isAssignableFrom(aClass)
                    || List.class.isAssignableFrom(aClass.getSuperclass())) {
                if (Modifier.isPrivate(aClass.getModifiers())
                        && Modifier.isStatic(aClass.getModifiers())) {

                    try {
                        Method getMethod = aClass.getDeclaredMethod("get", int.class);
                        getMethod.setAccessible(true);


                        Constructor<?> constructor = aClass.getDeclaredConstructor();
                        constructor.setAccessible(true);


                        getMethod.invoke(constructor.newInstance(), 0);
                    } catch (NoSuchMethodException ignored) {
                    } catch (InvocationTargetException e) {
                        if (e.getCause() instanceof IndexOutOfBoundsException) {
                            return aClass;
                        }
                    }
                    //System.out.println(aClass);
                }
            }
            //interArr = aClass.getInterfaces();
            //System.out.println(aClass);
            //System.out.println(Arrays.toString(interArr));

        }
        return null;
    }
}
