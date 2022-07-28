package les002.task2.dao;

import java.sql.Connection;

public interface DaoFactory {
    Connection getConnection();
    CarDao getCarDao(Connection connection);
}
