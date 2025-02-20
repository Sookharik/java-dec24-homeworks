package ru.otus.java.basic.homeworks.hw13;

public class Horse extends Transport {
    private int power;

    public Horse(int power) {
        this.power = power;
    }

    @Override
    boolean move(TerrainType locality, int distance) {
        if (power <= 0) {
            System.out.println("Сил должно быть больше нуля");
            return false;
        }
        if (locality == TerrainType.SWAMP) {
            System.out.println("Лошадь не может двигаться по " + locality.getType());
            return false;
        }
        if (power >= distance) {
            power -= distance;
            System.out.println("Лошадь преодолела расстояние " + distance + " км по " + locality.getType());
            System.out.println("Осталось выносливости " + power);
            return true;
        } else {
            System.out.println("Лошадь слишком устала для перемещения на " + distance + " км.");
            return false;
        }
    }
}