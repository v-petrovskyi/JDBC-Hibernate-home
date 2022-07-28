package les002.task3.entity;

public abstract class Car {
    private CarType carType;
    private int maxSpeed;
    private int qtyOfPassengers;
    private String model;
    private int price;
    private double fuelConsumption;

    public Car(CarType carType, int maxSpeed, int qtyOfPassengers, String model, int price, double fuelConsumption) {
        this.carType = carType;
        this.maxSpeed = maxSpeed;
        this.qtyOfPassengers = qtyOfPassengers;
        this.model = model;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getQtyOfPassengers() {
        return qtyOfPassengers;
    }

    public void setQtyOfPassengers(int qtyOfPassengers) {
        this.qtyOfPassengers = qtyOfPassengers;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("carType=").append(carType);
        sb.append(", maxSpeed=").append(maxSpeed);
        sb.append(", qtyOfPassengers=").append(qtyOfPassengers);
        sb.append(", model='").append(model).append('\'');
        sb.append(", price=").append(price);
        sb.append(", fuelConsumption=").append(fuelConsumption);
        sb.append('}');
        return sb.toString();
    }
}
