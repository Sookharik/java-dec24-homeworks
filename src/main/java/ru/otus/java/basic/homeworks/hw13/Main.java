package ru.otus.java.basic.homeworks.hw13;

/**
 * Создайте класс Человек с полями name (имя) и currentTransport (текущий транспорт)
 * Реализуйте в вашем приложении классы Машина, Лошадь, Велосипед, Вездеход
 * Каждый из классов должен предоставлять возможность перемещаться на определенное расстояние с указанием типа местности
 * В приложении должны быть типы местности: густой лес, равнина, болото
 * Человек должен иметь возможность сесть на любой из этих видов транспорта, встать с него,
 * или переместиться на некоторое расстояние (при условии что он находится на каком-либо транспорте)
 * При попытке выполнить перемещение у человека, не использующего транспорт, считаем что он просто идет указанное расстояние пешком
 * При перемещении Машина и Вездеход тратят бензин, который у них ограничен. Лошадь тратит силы.
 * Велосипед может использоваться без ограничений (можете для усложнения велосипедом тратить силы “водителя”).
 * При выполнении действия результат должен быть отпечатан в консоль
 * У каждого вида транспорта есть местности по которым он не может перемещаться: машина - густой лес и болото,
 * лошадь и велосипед - болото, вездеход - нет ограничений
 * При попытке переместиться должен быть возвращен результат true/false - удалось ли выполнить действие
 */

public class Main {
    public static void main(String[] args) {

        Human human = new Human("Aleks");

        Car car = new Car(50);
        Horse horse = new Horse(20);
        Bicycle bicycle = new Bicycle();
        Rover rover = new Rover(100);

        human.goTransport(car);
        human.move(TerrainType.SWAMP, 100);
        human.move(TerrainType.PLAIN, 20);
        human.move(TerrainType.DENSE_FOREST, 15);

        human.goTransport(rover);
        human.move(TerrainType.SWAMP, 10);
        human.move(TerrainType.PLAIN, 20);
        human.move(TerrainType.DENSE_FOREST, 75);

        human.goTransport(horse);
        human.move(TerrainType.SWAMP, 100);
        human.move(TerrainType.PLAIN, 20);
        human.move(TerrainType.DENSE_FOREST, 15);

        human.goTransport(bicycle);
        human.move(TerrainType.SWAMP, 100);
        human.move(TerrainType.PLAIN, 20);
        human.move(TerrainType.DENSE_FOREST, 15);

        human.standTransport();
        human.move(TerrainType.SWAMP, 100);
        human.move(TerrainType.PLAIN, 20);
        human.move(TerrainType.DENSE_FOREST, 15);
    }
}