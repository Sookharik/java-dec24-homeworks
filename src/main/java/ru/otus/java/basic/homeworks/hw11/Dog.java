package ru.otus.java.basic.homeworks.hw11;

public class Dog extends Animal {
    private int index = 2;

    public Dog(String name, double runSpeed, double swimSpeed, double endurance) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
        this.endurance = endurance;
    }

    public void swim(int distance) {
        if (endurance < (distance * 1)) {
            info();
            System.out.println("Время: " + "-1" + " " + timeUnit);
            System.out.println("Животное устало");
        }
        if (endurance >= (distance * index)) {
            endurance = endurance - (distance * 1);
            time = distance / swimSpeed;
            info();
            System.out.println("Проплыл дистанцию " + distance + " за " + time + " " + timeUnit);
        }
    }
}
