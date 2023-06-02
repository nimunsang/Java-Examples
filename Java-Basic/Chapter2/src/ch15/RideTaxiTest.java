package ch15;

public class RideTaxiTest {

    public static void main(String[] args) {
        Person Edward = new Person("Edward", 20000);
        Taxi taxi = new Taxi("잘나간다 운수");

        Edward.takeTaxi(taxi, 10000);
        Edward.showInfo();
        taxi.showInfo();
    }
}
