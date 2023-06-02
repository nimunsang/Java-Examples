package ch08;

public abstract class Computer {

    abstract void display();
    abstract void typing();

    public void turnOn() {
        System.out.println("전원 ON");
    }

    public void turnOff() {
        System.out.println("전원 OFF");
    }


}
