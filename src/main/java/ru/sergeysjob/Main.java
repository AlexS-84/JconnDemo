package ru.sergeysjob;

import org.apache.log4j.Logger;
import java.sql.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        String password;
        System.out.print("Ведите пароль Базы данных\n");
        password = input.nextLine();

        try {
            String url = "jdbc:mysql://localhost/jconndemo";
            String username = "root";
            //Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url,username,password)) {
                System.out.println("Успешное подключение, Друг!");

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery ("select * from boys");
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                System.out.printf("%s - %s\n", name, city);
            }
            }
        } catch (Exception ex) {
            logger.info(ex);
        }
    }
}

