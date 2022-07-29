package les002.task2.dao;

import les002.task3.entity.Car;

import java.util.List;

public interface CarDao {
    List<Car> getCarList();
    void addCar(Car car);
    List<Car> sortCars();
    int totalCostOfCars();
    List<Car> getChosenCars(int minSpeed, int maxSpeed);

}
