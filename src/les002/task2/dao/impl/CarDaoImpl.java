package les002.task2.dao.impl;

import les002.task2.dao.CarDao;
import les002.task2.dao.ConnectionFactory;
import les002.task3.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        List<Car> carList = new ArrayList<>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT car_type, max_speed, passengers, model, price, fuel_consumption FROM car");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int maxSpeed = resultSet.getInt("max_speed");
                int qtyOfPassengers = resultSet.getInt("passengers");
                String model = resultSet.getString("model");
                int price = resultSet.getInt("price");
                double fuelConsumption = resultSet.getDouble("fuel_consumption");
                Car car = null;
                switch (resultSet.getString("car_type")) {
                    case "COUPE":
                        car = new Coupe(maxSpeed, qtyOfPassengers, model, price, fuelConsumption);
                    case "SEDAN":
                        car = new Sedan(maxSpeed, qtyOfPassengers, model, price, fuelConsumption);
                    case "SUV":
                        car = new Suv(maxSpeed, qtyOfPassengers, model, price, fuelConsumption);
                    case "VAN":
                        car = new Van(maxSpeed, qtyOfPassengers, model, price, fuelConsumption);
                    case "HATCHBACK":
                        car = new Hatchback(maxSpeed, qtyOfPassengers, model, price, fuelConsumption);
                }
                carList.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }

    @Override
    public void addCar(Car car) {
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO car(car_type, max_speed, passengers, model, price, fuel_consumption) VALUES (?, ?, ?, ?, ?, ?)");
            String type = null;
            if (car.getCarType() == CarType.COUPE) {
                type = "COUPE";
            } else if (car.getCarType() == CarType.SEDAN) {
                type = "SEDAN";
            } else if (car.getCarType() == CarType.HATCHBACK) {
                type = "HATCHBACK";
            } else if (car.getCarType() == CarType.VAN) {
                type = "VAN";
            } else if (car.getCarType() == CarType.SUV) {
                type = "SUV";
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
    public List<Car> sortCars() {
        List<Car> carList = new ArrayList<>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT car_type, max_speed, passengers, model, price, fuel_consumption FROM car ORDER BY fuel_consumption");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int maxSpeed = resultSet.getInt("max_speed");
                int qtyOfPassengers = resultSet.getInt("passengers");
                String model = resultSet.getString("model");
                int price = resultSet.getInt("price");
                double fuelConsumption = resultSet.getDouble("fuel_consumption");
                Car car = null;
                switch (resultSet.getString("car_type")) {
                    case "COUPE":
                        car = new Coupe(maxSpeed, qtyOfPassengers, model, price, fuelConsumption);
                    case "SEDAN":
                        car = new Sedan(maxSpeed, qtyOfPassengers, model, price, fuelConsumption);
                    case "SUV":
                        car = new Suv(maxSpeed, qtyOfPassengers, model, price, fuelConsumption);
                    case "VAN":
                        car = new Van(maxSpeed, qtyOfPassengers, model, price, fuelConsumption);
                    case "HATCHBACK":
                        car = new Hatchback(maxSpeed, qtyOfPassengers, model, price, fuelConsumption);
                }
                carList.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }

    @Override
    public int totalCostOfCars() {
        int totalCost = 0;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT SUM(price) FROM car");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                totalCost = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalCost;
    }

    @Override
    public List<Car> getChosenCars(int minSpeedInput, int maxSpeedInput) {
        List<Car> carList = new ArrayList<>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT car_type, max_speed, passengers, model, price, fuel_consumption FROM car WHERE max_speed BETWEEN ? AND ?;");
            preparedStatement.setInt(1, minSpeedInput);
            preparedStatement.setInt(2, maxSpeedInput);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int maxSpeed = resultSet.getInt("max_speed");
                int qtyOfPassengers = resultSet.getInt("passengers");
                String model = resultSet.getString("model");
                int price = resultSet.getInt("price");
                double fuelConsumption = resultSet.getDouble("fuel_consumption");
                Car car = null;
                switch (resultSet.getString("car_type")) {
                    case "COUPE":
                        car = new Coupe(maxSpeed, qtyOfPassengers, model, price, fuelConsumption);
                    case "SEDAN":
                        car = new Sedan(maxSpeed, qtyOfPassengers, model, price, fuelConsumption);
                    case "SUV":
                        car = new Suv(maxSpeed, qtyOfPassengers, model, price, fuelConsumption);
                    case "VAN":
                        car = new Van(maxSpeed, qtyOfPassengers, model, price, fuelConsumption);
                    case "HATCHBACK":
                        car = new Hatchback(maxSpeed, qtyOfPassengers, model, price, fuelConsumption);
                }
                carList.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }
}
