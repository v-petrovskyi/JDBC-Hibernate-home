package les002.task3.entity;

public class Hatchback extends Car{
    public Hatchback(int maxSpeed, int qtyOfPassengers, String model, int price, double fuelConsumption) {
        super(CarType.HATCHBACK, maxSpeed, qtyOfPassengers, model, price, fuelConsumption);
    }
}
