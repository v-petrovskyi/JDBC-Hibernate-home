package les002.task3;

import les002.task3.entity.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> taksopark = new ArrayList<>();
        taksopark.add(new Sedan(165, 4, "Passat", 15_000, 10.5));
        taksopark.add(new Sedan(150, 4, "Accord", 19_000, 9.5));
        taksopark.add(new Coupe(160, 1, "Z350", 25_000, 11.5));
        taksopark.add(new Coupe(250, 1, "911 turbo", 95_000, 15.4));
        taksopark.add(new Hatchback(180, 4, "Golf", 10_000, 5.4));
        taksopark.add(new Hatchback(160, 4, "Focus", 9_000, 6.3));
        taksopark.add(new Suv(160, 4, "H3", 30_000, 18.3));
        taksopark.add(new Suv(190, 4, "Land Cruiser", 35_000, 15.3));
        taksopark.add(new Van(155, 6, "Touran", 10_500, 8.3));
        taksopark.add(new Van(165, 7, "Zafira", 9_500, 7.3));

        // todo написати консоль


        System.out.println(totalCarCost(taksopark));

        int min = 150;
        int max = 160;
        choiseCar(taksopark, min, max);

        sortingByFuel(taksopark);

        System.out.println(taksopark);

    }

    private static void choiseCar(List<Car> taksopark, int min, int max) {
        taksopark.stream().filter(x -> (x.getMaxSpeed() >= min) && (x.getMaxSpeed() <= max)).forEach(System.out::println);
    }

    private static void sortingByFuel(List<Car> taksopark) {
        taksopark.sort(Comparator.comparingDouble(Car::getFuelConsumption));
    }

    private static int totalCarCost(List<Car> taksopark) {
        int totalCostOfCars = 0;
        for (Car car : taksopark) {
            totalCostOfCars += car.getPrice();
        }
        return totalCostOfCars;
    }
}
