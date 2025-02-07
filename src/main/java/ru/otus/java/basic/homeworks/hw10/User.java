package ru.otus.java.basic.homeworks.hw10;

/**
 * Создайте класс Пользователь (User) с полями: фамилия, имя, отчество, год рождения, email;
 * <p>
 * Реализуйте у класса конструктор, позволяющий заполнять эти поля при создании объекта;
 * <p>
 * В классе Пользователь реализуйте метод, выводящий в консоль информацию о пользователе в виде:
 * ФИО: фамилия имя отчество
 * Год рождения: год рождения
 * e-mail: email
 */

public class User {
    private String surname;
    private String name;
    private String patronymic;
    private int yearBirth;
    private String email;

    public int getYearBirth() {
        return yearBirth;
    }

    public User(String surname, String name, String patronymic, int yearBirth, String email) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.yearBirth = yearBirth;
        this.email = email;
    }

    public void info() {
        System.out.println("ФИО: " + surname + " " + name + " " + patronymic);
        System.out.println("Год рождения: " + yearBirth);
        System.out.println("e-mail: " + email);
    }
}
