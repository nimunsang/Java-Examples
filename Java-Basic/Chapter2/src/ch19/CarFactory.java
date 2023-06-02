package ch19;

public class CarFactory {

    private static int serialNumber = 10000;
    private static CarFactory instance = new CarFactory();

    private CarFactory() {}

    public static CarFactory getInstance() {
        if (instance == null) {
            instance = new CarFactory();
        }
        return instance;
    }

    public Car createCar() {
        serialNumber += 1;
        return new Car(serialNumber);
    }
}
