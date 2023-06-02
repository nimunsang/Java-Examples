package ch15;

public class Person {

    String name;
    int money;

    public Person(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void takeTaxi(Taxi taxi, int money) {
        this.money -= money;
        taxi.earn += money;
    }

    public void showInfo() {
        System.out.println(this.name + "님의 남은 돈은 " + this.money + "원 입니다.");
    }
}
