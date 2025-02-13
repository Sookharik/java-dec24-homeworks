package ru.otus.java.basic.homeworks.hw11.animal;

public class Horse extends Animal {

    public Horse(String name, double runSpeed, double swimSpeed, double endurance) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
        this.endurance = endurance;
        this.swimIndex = 4;
    }
}