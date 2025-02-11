package ru.otus.java.basic.homeworks.hw11.animal;

public class Cat extends Animal {
    public Cat(String name, double runSpeed, double endurance) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.endurance = endurance;
    }

    @Override
    public double swim(int distance) {
        info();
        System.out.println("Кот плавать не умеет!");
        return time;
    }
}

