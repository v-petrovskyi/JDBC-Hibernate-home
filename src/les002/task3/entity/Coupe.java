package les002.task3.entity;

public class Coupe extends Car{
    public Coupe( int maxSpeed, int qtyOfPassengers, String model, int price, double fuelConsumption) {
        super(CarType.COUPE, maxSpeed, qtyOfPassengers, model, price, fuelConsumption);
    }
}
