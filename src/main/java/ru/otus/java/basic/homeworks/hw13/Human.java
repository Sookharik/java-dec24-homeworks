package ru.otus.java.basic.homeworks.hw13;

/**
 * Создайте класс Человек с полями name (имя) и currentTransport (текущий транспорт)
 * Реализуйте в вашем приложении классы Машина, Лошадь, Велосипед, Вездеход
 * Каждый из классов должен предоставлять возможность перемещаться на определенное расстояние с указанием типа местности
 * В приложении должны быть типы местности: густой лес, равнина, болото
 * Человек должен иметь возможность сесть на любой из этих видов транспорта, встать с него, или переместиться на некоторое расстояние (при условии что он находится на каком-либо транспорте)
 * При попытке выполнить перемещение у человека, не использующего транспорт, считаем что он просто идет указанное расстояние пешком
 * При перемещении Машина и Вездеход тратят бензин, который у них ограничен. Лошадь тратит силы. Велосипед может использоваться без ограничений (можете для усложнения велосипедом тратить силы “водителя”). При выполнении действия результат должен быть отпечатан в консоль
 * У каждого вида транспорта есть местности по которым он не может перемещаться: машина - густой лес и болото, лошадь и велосипед - болото, вездеход - нет ограничений
 * При попытке переместиться должен быть возвращен результат true/false - удалось ли выполнить действие
 */

public class Human {
    private String name;
    private Transport currentTransport;

    public Human(String name) {
        this.name = name;
    }

    public void goTransport(Transport transport) {
        this.currentTransport = transport;
        System.out.println(name + " сел(а) на " + currentTransport.getClass().getSimpleName());
    }

    public void standTransport() {
        if (currentTransport != null) {
            System.out.println(name + " встал(а) с " + currentTransport.getClass().getSimpleName());
            currentTransport = null;
        } else {
            System.out.println(name + " не использует транспорт");
        }
    }

    public boolean move(TerrainType locality, int distance) {
        if (distance <= 0) {
            System.out.println("Расстояние должно быть положительным числом.");
            return false;
        }
        if (currentTransport != null) {
            return currentTransport.move(locality, distance);
        } else {
            System.out.println(name + " идет пешком " + distance + " км по " + locality.getType());
            return true;
        }
    }
}