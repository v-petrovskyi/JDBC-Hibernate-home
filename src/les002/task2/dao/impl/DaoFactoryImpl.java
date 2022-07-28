package les002.task2.dao.impl;

import les002.task2.dao.CarDao;
import les002.task2.dao.DaoFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactoryImpl implements DaoFactory {
    private static Connection connection;


    @Override
    public Connection getConnection() {
        if (connection == null) {
            final String URL = "jdbc:mysql://localhost:3306/myjoinsdb1";
            final String LOGIN = "root";
            final String PASS = "root1";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                connection = DriverManager.getConnection(URL, LOGIN, PASS);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    @Override
    public CarDao getCarDao(Connection connection) {
        return null;
    }
}
