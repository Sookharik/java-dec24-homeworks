package ru.otus.java.basic.homeworks.hw11.animal;

public class Horse extends Animal {

    public Horse(String name, double runSpeed, double swimSpeed, double endurance) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
        this.endurance = endurance;
        this.swimIndex = 4;
    }

    public double swim(int distance) {
        if (endurance < (distance * swimIndex)) {
            info();
            System.out.println("Животное устало");
            return time = -1;
        }
        endurance = endurance - (distance * swimIndex);
        time = distance / swimSpeed;
        info();
        return time;
    }
}

