package ru.otus.java.basic.homeworks.hw11;

public class Horse extends Animal {
    private int index = 4;

    public Horse(String name, double runSpeed, double swimSpeed, double endurance) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
        this.endurance = endurance;
    }

    public void swim(int distance) {
        if (endurance < (distance * index)) {
            info();
            System.out.println("Время: " + "-1" + " " + timeUnit);
            System.out.println("Животное устало");
        }
        if (endurance >= (distance * index)) {
            endurance = endurance - (distance * index);
            time = distance / swimSpeed;
            info();
            System.out.println("Проплыла дистанцию " + distance + " за " + time + " " + timeUnit);
        }
    }
}
