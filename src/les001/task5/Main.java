package les001.task5;

import java.sql.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        final String URL = "jdbc:mysql://localhost:3306/myjoinsdb1";
        final String LOGIN = "root";
        final String PASS = "root1";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASS);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT Name, Phone, PlaceOfLive FROM info i INNER JOIN phones p ON i.id = p.id");
            System.out.println("1) Получите контактные данные сотрудников (номера телефонов, место жительства)");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String placeOfLive = resultSet.getString("PlaceOfLive");
                System.out.println(name + " " + phone + " " + " " + placeOfLive);
            }
            resultSet = statement.executeQuery("SELECT Name, Phone, DateOfBirth FROM info i INNER JOIN phones p on i.id = p.id WHERE marital_status='notmarried'");
            System.out.println("2) Получите информацию о дате рождения всех холостых сотрудников и их номера.");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                Date dateOfBirth = resultSet.getDate("DateOfBirth");
                System.out.println(name + " " + phone + " " + dateOfBirth);
            }
            resultSet = statement.executeQuery("SELECT Name, DateOfBirth, Phone FROM info i JOIN phones p ON p.id = i.id JOIN salaryandposition s ON p.id = s.id WHERE position = 'менеджер'");
            System.out.println("3) Получите информацию обо всех менеджерах компании: дату рождения и номер телефона.");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Date dateOfBirth = resultSet.getDate("DateOfBirth");
                String phone = resultSet.getString("phone");
                System.out.println(name + " " + dateOfBirth + " " + phone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}
