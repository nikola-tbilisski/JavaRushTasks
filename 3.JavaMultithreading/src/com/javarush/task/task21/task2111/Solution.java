package com.javarush.task.task21.task2111;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/* 
Освобождаем ресурсы
free up resources connection to SQL data base jdbc driver
*/

public class Solution {
    private Connection connection;

    public Solution(Connection connection) {
        this.connection = connection;
    }

    @Override
    protected void finalize() throws Throwable
        {
            super.finalize();
            if(connection != null) connection.close();
        }

    public List<User> getUsers() {
        String query = "select ID, DISPLAYED_NAME, LEVEL, LESSON from USER";

        List<User> result = new LinkedList();

        try(Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query))
        {
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("DISPLAYED_NAME");
                int level = rs.getInt("LEVEL");
                int lesson = rs.getInt("LESSON");

                result.add(new User(id, name, level, lesson));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = null;
        }

        return result;

    }

    public static class User {
        private int id;
        private String name;
        private int level;
        private int lesson;

        public User(int id, String name, int level, int lesson) {
            this.id = id;
            this.name = name;
            this.level = level;
            this.lesson = lesson;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", level=" + level +
                    ", lesson=" + lesson +
                    '}';
        }
    }

    public static void main(String[] args){
        try (Connection con = Solution.connect("DataBase_Name")) {
            System.out.println("Подключение успешно выполнено");
        } catch (SQLException e) {
            e.printStackTrace();
        }    }

    public static Connection connect(String db) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + db +
                            "?characterEncoding=utf8&serverTimezone=UTC", "user_name", "passw");
        } catch (ClassNotFoundException e) {
            System.out.println("Драйвер не найден");
            System.exit(1);
        } catch (SQLException e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.exit(1);
        }
        return con;    }
}
