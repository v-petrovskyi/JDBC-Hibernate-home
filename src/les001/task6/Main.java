package les001.task6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
            statement.execute("CREATE TABLE test_table (id INT AUTO_INCREMENT NOT NULL PRIMARY KEY, user_name VARCHAR(30), password VARCHAR(30))");
            statement.executeUpdate("INSERT INTO test_table(user_name, password) VALUES ('Andrii', 'qwerty123')");
            statement.executeUpdate("INSERT INTO test_table(user_name, password) VALUES ('super_user', 'jkf:OUG40(&')");
            statement.executeUpdate("INSERT INTO test_table(user_name, password) VALUES ('John', 'some-password')");
            statement.executeUpdate("INSERT INTO test_table(user_name, password) VALUES ('Olga', '****')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
