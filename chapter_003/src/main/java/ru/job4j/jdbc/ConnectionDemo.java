package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Config c = new Config("chapter_003/src/main/resources/app.properties");
        c.load();

        String url = c.value("url");
        String login = c.value("login");
        String password = c.value("password");
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
