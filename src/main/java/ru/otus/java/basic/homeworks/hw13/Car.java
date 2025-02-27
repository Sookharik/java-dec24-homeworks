package ru.otus.java.basic.homeworks.hw13;

public class Car extends Transport {
    private int petrol;

    public Car(int petrol) {
        this.petrol = petrol;
    }

    @Override
    boolean move(TerrainType locality, int distance) {
        if (petrol <= 0) {
            System.out.println("Бензина должно быть больше нуля");
            return false;
        }
        if (locality == TerrainType.DENSE_FOREST || locality == TerrainType.SWAMP) {
            System.out.println("Машина не может проехать по " + locality.getType());
            return false;
        }
        if (petrol >= distance) {
            petrol -= distance;
            System.out.println("Машина проехала расстояние " + distance + " км по " + locality.getType());
            System.out.println("Осталось бензина " + petrol);
            return true;
        } else {
            System.out.println("Недостаточно бензина для перемещения на " + distance + " км.");
            return false;
        }
    }
}