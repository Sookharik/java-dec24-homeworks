package ru.otus.java.basic.homeworks.hw10;

/**
 * В методе main() Main класса создайте массив из 10 пользователей и заполните его объектами и
 * с помощью цикла выведите информацию только о пользователях старше 40 лет.
 */

public class Main {
    public static void main(String[] args) {

        Box box = new Box(10, 11, 12, "blue");
        box.putItem("apple");
        box.info();
        box.open();
        box.putItem("apple");
        box.info();

        box.paint("red");
        box.info();

        box.close();
        box.takeItem();
        box.info();


        User[] arrayUser = new User[10];

        arrayUser[0] = new User("Иванов", "Иван", "Иванович", 1990, "ivanov@example.com");
        arrayUser[1] = new User("Петрова", "Анна", "Сергеевна", 1985, "petrova@example.com");
        arrayUser[2] = new User("Сидоров", "Алексей", "Викторович", 1995, "sidorov@example.com");
        arrayUser[3] = new User("Козлова", "Екатерина", "Дмитриевна", 2000, "kozlovа@example.com");
        arrayUser[4] = new User("Николаев", "Николай", "Николаевич", 1975, "nikolaev@example.com");
        arrayUser[5] = new User("Смирнова", "Ольга", "Александровна", 1888, "smirnova@example.com");
        arrayUser[6] = new User("Кузнецов", "Денис", "Павлович", 1992, "kuznetsov@example.com");
        arrayUser[7] = new User("Васильева", "Марина", "Игоревна", 1998, "vasilieva@example.com");
        arrayUser[8] = new User("Морозов", "Артём", "Владимирович", 1980, "morozov@example.com");
        arrayUser[9] = new User("Федорова", "Татьяна", "Олеговна", 1993, "fedorova@example.com");

        int year = 2025;

        for (int i = 0; i < arrayUser.length; i++) {
            if (year - arrayUser[i].getYearBirth() > 40) {
                arrayUser[i].info();
                System.out.println();
            }
        }


    }
}
