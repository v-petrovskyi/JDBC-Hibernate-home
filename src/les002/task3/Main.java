package les002.task3;

import les002.task3.entity.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Car> taksopark;

    public static void main(String[] args) {
        taksopark = new ArrayList<>();
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

        consol();
    }

    private static void consol() {
        System.out.println("""
                \tВиберіть пункт меню:
                1 Подсчитать стоимость автопарка
                2 Провести сортировку автомобилей парка по расходу топлива
                3 Найти автомобиль в компании, соответствующий заданному диапазону параметров скорости
                4 вийти""");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input) {
            case 1 -> {
                System.out.println("стоимость автопарка: " + totalCarCost(taksopark));
                consol();
            }
            case 2 -> {
                sortingByFuel(taksopark);
                System.out.println(taksopark);
                consol();
            }
            case 3 -> {
                System.out.println("введіть мінімальну швидкість");

                int min = scanner.nextInt();
                System.out.println("введіть максимальну швидкість");
                int max = scanner.nextInt();
                choiseCar(taksopark, min, max);
                consol();
            }
            case 4 -> System.exit(0);
        }
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
