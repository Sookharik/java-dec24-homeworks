package ru.otus.java.basic.homeworks.hw13;

public enum TerrainType {
    PLAIN("равнине"),
    SWAMP("болоту"),
    DENSE_FOREST("густому лесу");

    private final String type;

    TerrainType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}