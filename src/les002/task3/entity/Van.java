package les002.task3.entity;

public class Van extends Car{
    public Van(int maxSpeed, int qtyOfPassengers, String model, int price, double fuelConsumption) {
        super(CarType.VAN, maxSpeed, qtyOfPassengers, model, price, fuelConsumption);
    }
}
