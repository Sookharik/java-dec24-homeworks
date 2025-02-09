package ru.otus.java.basic.homeworks.hw11;

public class Cat extends Animal {
    public Cat(String name, double runSpeed, double endurance) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.endurance = endurance;
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот плавать не умеет!");
    }
}

