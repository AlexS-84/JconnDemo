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
        try {
            //String url = "jdbc:mysql://localhost/jconndemo";
            //String username = "root";
            //String password = "test1234";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = getConnection()) {
                System.out.println("Успешное подключение, Друг!");
            }
        } catch (Exception ex) {
            logger.info(ex);
        }
    }

    public static Connection getConnection() throws SQLException, IOException {

        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("database.properties"))) {
            props.load(in);
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }
}

