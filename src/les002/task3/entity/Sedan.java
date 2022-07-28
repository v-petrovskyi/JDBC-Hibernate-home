package les002.task3.entity;

public class Sedan extends Car{

    public Sedan( int maxSpeed, int qtyOfPassengers, String model, int price, double fuelConsumption) {
        super(CarType.SEDAN, maxSpeed, qtyOfPassengers, model, price, fuelConsumption);
    }
}
