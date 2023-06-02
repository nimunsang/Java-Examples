package ch06;

public class Person {

    public String gender;
    public String name;
    public int height;
    public int weight;
    public int age;

    public Person(String gender, String name, int height, int weight, int age) {
        this.gender = gender;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.age = age;

    }

    public void showPersonDetails() {
        System.out.println("키가 " + this.height + "이고, " +
                "몸무게가 " + this.weight + "킬로인 남성이 있다. " +
                "이름은 " + this.name + "이고, " +
                "나이는 " + this.age + "세이다.");
    }

    public static void main(String[] args) {
        Person person = new Person("남성", "Tomas", 180, 78, 37);
        person.showPersonDetails();
    }
}
