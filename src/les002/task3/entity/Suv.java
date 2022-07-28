package les002.task3.entity;

public class Suv extends Car{
    public Suv(int maxSpeed, int qtyOfPassengers, String model, int price, double fuelConsumption) {
        super(CarType.SUV, maxSpeed, qtyOfPassengers, model, price, fuelConsumption);
    }
}
