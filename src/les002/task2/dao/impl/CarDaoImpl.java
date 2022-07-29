package les002.task2.dao.impl;

import les002.task2.dao.CarDao;
import les002.task2.dao.ConnectionFactory;
import les002.task3.entity.Car;
import les002.task3.entity.CarType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CarDaoImpl implements CarDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;


    private Connection getConnection() {
        return ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public List<Car> getCarList() {
        return null;
    }

    @Override
    public void addCar(Car car) {
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO car(car_type, max_speed, passengers, model, price, fuel_consumption) VALUES (?, ?, ?, ?, ?, ?)");
            String type = null;
            if (car.getCarType()== CarType.COUPE){
                type="COUPE";
            } else if (car.getCarType()==CarType.SEDAN){
                type="SEDAN";
            } else if (car.getCarType() == CarType.HATCHBACK) {
                type="HATCHBACK";
            } else if (car.getCarType() == CarType.VAN) {
                type = "VAN";
            } else if (car.getCarType() == CarType.SUV) {
                type="SUV";
            }
            preparedStatement.setString(1, type);
            preparedStatement.setInt(2, car.getMaxSpeed());
            preparedStatement.setInt(3, car.getQtyOfPassengers());
            preparedStatement.setString(4, car.getModel());
            preparedStatement.setInt(5, car.getPrice());
            preparedStatement.setDouble(6, car.getFuelConsumption());
            preparedStatement.executeUpdate();
            System.out.printf("авто моделі %s успішно додано\n", car.getModel());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public List<Car> sortCars(List<Car> carList) {
        return null;
    }

    @Override
    public int totalCostOfCars() {
        return 0;
    }

    @Override
    public List<Car> getChosenCars(int minSpeed, int maxSpeed) {
        return null;
    }
}
