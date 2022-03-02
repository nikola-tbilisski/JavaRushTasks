package com.javarush.task.task21.task2107;

import javax.jws.soap.SOAPBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
Deep clone LinkedHashMap
*/

public class Solution implements Cloneable {

    @Override
    public boolean equals(Object o)
        {
            if (this == o) return true;
            if (!( o instanceof Solution )) return false;
            Solution solution = (Solution) o;
            return Objects.equals(users, solution.users);
        }

    @Override
    public int hashCode()
        {
            return Objects.hash(users);
        }

    @Override
    protected Solution clone() throws CloneNotSupportedException
        {
            Solution clone = (Solution) super.clone();
            clone.users = new LinkedHashMap<>(users.size());

            for(Map.Entry<String, User> entry: users.entrySet()){
                clone.users.put(entry.getKey(), entry.getValue().clone());
            }
            return clone;
        }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

           /* for(Map.Entry<String, User> entry: solution.users.entrySet()){
                System.out.println(entry.getKey() + " " + entry.getValue().age + " " + entry.getValue().name);
            }

            for(Map.Entry<String, User> entry: clone.users.entrySet()){
                System.out.println(entry.getKey() + " " + entry.getValue().age + " " + entry.getValue().name);
            }

            for(Map.Entry<String, User> entry: clone.users.entrySet()){
               entry.getValue().name = "Shubert";
            }
            for(Map.Entry<String, User> entry: clone.users.entrySet()){
                System.out.println(entry.getKey() + " " + entry.getValue().age + " " + entry.getValue().name);
            }

            for(Map.Entry<String, User> entry: solution.users.entrySet()){
                System.out.println(entry.getKey() + " " + entry.getValue().age + " " + entry.getValue().name);
            }*/

            System.out.println(solution.users);
            System.out.println(clone.users);

            System.out.println(solution.users.equals(clone.users));

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap<>();

    public static class User implements Cloneable {
        int age;
        String name;

        @Override
        protected User clone() throws CloneNotSupportedException
            {
                return (User) super.clone();
            }

        @Override
        public boolean equals(Object o)
            {
                if (this == o) return true;
                if (!( o instanceof User )) return false;
                User user = (User) o;
                return age == user.age && Objects.equals(name, user.name);
            }

        @Override
        public int hashCode()
            {
                return Objects.hash(age, name);
            }

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
