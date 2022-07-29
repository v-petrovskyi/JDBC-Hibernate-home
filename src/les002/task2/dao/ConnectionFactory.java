package les002.task2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/hibernate_les02";
    private final String LOGIN = "root";
    private final String PASS = "root1";

    private static ConnectionFactory connectionFactory = null;

    private ConnectionFactory() {
        try{
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static ConnectionFactory getInstance(){
        if (connectionFactory==null){
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
