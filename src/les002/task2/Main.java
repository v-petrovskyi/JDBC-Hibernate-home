package les002.task2;

import les002.task2.dao.CarDao;
import les002.task2.dao.impl.CarDaoImpl;
import les002.task3.entity.*;

public class Main {
    public static void main(String[] args) {
        Car car = new Sedan(165, 4, "Passat", 15_000, 10.5);
        Car car2 = new Sedan(150, 4, "Accord", 19_000, 9.5);
        Car car3 = new Coupe(160, 1, "Z350", 25_000, 11.5);
        Car car4 = new Coupe(250, 1, "911 turbo", 95_000, 15.4);
        Car car5 = new Hatchback(180, 4, "Golf", 10_000, 5.4);
        Car car6 = new Hatchback(160, 4, "Focus", 9_000, 6.3);
        Car car7 = new Suv(160, 4, "H3", 30_000, 18.3);
        Car car8 = new Suv(190, 4, "Land Cruiser", 35_000, 15.3);
        Car car9 = new Van(155, 6, "Touran", 10_500, 8.3);
        Car car10 = new Van(165, 7, "Zafira", 9_500, 7.3);

        //------------------------------------------------

        CarDao carDao = new CarDaoImpl();
        carDao.addCar(car);
        carDao.addCar(car2);
        carDao.addCar(car3);
        carDao.addCar(car4);
        carDao.addCar(car5);
        carDao.addCar(car6);
        carDao.addCar(car7);
        carDao.addCar(car8);
        carDao.addCar(car9);
        carDao.addCar(car10);



    }
}
