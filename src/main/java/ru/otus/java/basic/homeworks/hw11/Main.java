package ru.otus.java.basic.homeworks.hw11;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Cat("Том", 5, 4);
        Animal dog = new Dog("Макс", 8, 11, 12);
        Animal horse = new Horse("Плотва", 20, 5, 200);

        cat.info();
        cat.run(20);
        cat.swim(1);

        dog.info();
        dog.run(11);
        dog.swim(20);

        horse.info();
        horse.run(50);
        horse.swim(10);

    }
}
