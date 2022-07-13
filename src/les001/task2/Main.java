package les001.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        final String URL = "jdbc:mysql://localhost:3306/myjoinsdb1";
        final String LOGIN = "root";
        final String PASS = "root1";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        File file = new File("src/les001/task1/sql query.txt");
        Scanner scanner = new Scanner(file);
        Connection connection = null;
        Statement statement = null;

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            try {
                connection = DriverManager.getConnection(URL, LOGIN, PASS);
                statement = connection.createStatement();
                statement.execute(line);
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
}
