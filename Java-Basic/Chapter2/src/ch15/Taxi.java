package ch15;

public class Taxi {

    String name;
    int earn;

    public Taxi(String name) {
        this.name = name;
        this.earn = 0;
    }

    public void showInfo() {
        System.out.println(this.name + "택시 수입은 " + this.earn + "원 입니다.");
    }
}
