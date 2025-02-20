package ru.otus.java.basic.homeworks.hw13;

public class Bicycle extends Transport {
    @Override
    boolean move(TerrainType locality, int distance) {
        if (locality == TerrainType.SWAMP) {
            System.out.println("Велосипед не может проехать по " + locality.getType());
            return false;
        }
        System.out.println("Велосипед проехал " + distance + " км по " + locality.getType());
        return true;
    }
}