package io.hexlet;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        var connection = DriverManager.getConnection("jdbc:h2:mem:hexlet_test");

        var query = "CREATE TABLE users (id BIGINT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(255), phone VARCHAR(255));";
        var statement = connection.createStatement();
        statement.execute(query);
        statement.close();

        var query2 = "INSERT INTO users (username, phone) VALUES ('tommy', '123456789')";
        var statement2 = connection.createStatement();
        statement2.executeUpdate(query2);
        statement2.close();

        var query3 = "SELECT * FROM users";
        var statement3 = connection.createStatement();
        var resultSet = statement3.executeQuery(query3);

        while (resultSet.next()) {
            System.out.println(resultSet.getLong("id"));
            System.out.println(resultSet.getString("username"));
            System.out.println(resultSet.getString("phone"));
        }
        statement3.close();

        connection.close();
    }

}
