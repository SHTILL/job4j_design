package ru.job4j.jdbc;

import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = null;
        String login = null;
        String password = null;

        try (BufferedReader r = new BufferedReader(new FileReader("chapter_003/src/main/java/ru/job4j/jdbc/app.properties"))) {
            Pattern p = Pattern.compile("^\\w+=\\S+$");
            String line;
            while ((line = r.readLine()) != null) {
                Matcher m = p.matcher(line);
                if (m.matches()) {
                    String[] tokens = line.split("=", 2);
                    switch (tokens[0]) {
                        case "password":
                            password = tokens[1];
                            break;
                        case "login":
                            login = tokens[1];
                            break;
                        case "url":
                            url = tokens[1];
                            break;
                        default:
                            System.out.println("Unknown option^ " + tokens[1]);
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File is not found");
            return;
        }
        if (url == null || login == null || password == null) {
            System.out.println("url or login or password is not specified in \"app.properties\"");
            return;
        }
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
