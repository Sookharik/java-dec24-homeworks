package ru.otus.java.basic.homeworks.hw10;

/**
 * Попробуйте реализовать класс по его описания: объекты класса Коробка должны иметь размеры и цвет.
 * Коробку можно открывать и закрывать. Коробку можно перекрашивать.
 * Изменить размер коробки после создания нельзя.
 * У коробки должен быть метод, печатающий информацию о ней в консоль.
 * В коробку можно складывать предмет (если в ней нет предмета), или выкидывать его оттуда
 * (только если предмет в ней есть), только при условии что коробка открыта (предметом читаем просто строку).
 * Выполнение методов должно сопровождаться выводом сообщений в консоль.
 */

public class Box {
    private int width;
    private int height;
    private int depth;
    private String color;
    private boolean toggle;
    private String item;

    public Box(int width, int height, int depth, String color) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.color = color;
        this.toggle = false;
        this.item = null;
        System.out.println("Коробка создана!");
        info();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void info() {
        System.out.println("============== Коробка ==============");
        System.out.println("Размер коробки: " + width + "x" + height + "x" + depth);
        System.out.println("Цвет коробки: " + color);
        if (toggle) {
            System.out.println("Коробка открыта.");
        } else {
            System.out.println("Коробка закрыта.");
        }
        if (item != null) {
            System.out.println("Предмет внутри " + item);
        } else {
            System.out.println("Внутри нет предмета.");
        }
        System.out.println("=====================================");
    }

    public void open() {
        if (!toggle) {
            toggle = true;
            System.out.println("Открываем коробку.");
        } else {
            System.out.println("Коробка уже открыта.");
        }
    }

    public void close() {
        if (toggle) {
            toggle = false;
            System.out.println("Закрываем коробку.");
        } else {
            System.out.println("Коробка уже закрыта.");
        }
    }

    public void paint(String newColor) {
        this.color = newColor;
        System.out.println("Коробка покрашена в " + color);
    }

    public void putItem(String item) {
        if (!toggle) {
            System.out.println("Нельзя положить предмет в коробку, она закрыта.");
            return;
        }
        if (this.item != null) {
            System.out.println("В коробке уже есть предмет: " + this.item);
            return;
        }
        this.item = item;
        System.out.println("В коробку положили предмет: " + item);
    }

    public void takeItem() {
        if (!toggle) {
            System.out.println("Нельзя вытащить предмет из коробки она закрыта.");
            return;
        }
        if (this.item == null) {
            System.out.println("В коробке нет предметов.");
            return;
        }
        System.out.println("Вытащили предмет " + this.item + " из коробки. ");
        this.item = null;
    }
}

