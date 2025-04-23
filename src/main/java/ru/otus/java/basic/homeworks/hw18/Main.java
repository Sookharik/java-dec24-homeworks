package ru.otus.java.basic.homeworks.hw18;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        PersonDataBase personDataBase = new PersonDataBase();

        Person person1 = new Person("Иван", Position.MANAGER, 1L);
        Person person2 = new Person("Петр", Position.DEVELOPER, 2L);
        Person person3 = new Person("Анна", Position.JUNIOR_DEVELOPER, 3L);

        personDataBase.add(person1);
        personDataBase.add(person2);
        personDataBase.add(person3);

        System.out.println("Найден: " + personDataBase.findById(1L).getName());

        System.out.println("Является ли Иван менеджером? " + personDataBase.isManager(person1));
        System.out.println("Является ли Петр менеджером? " + personDataBase.isManager(person2));

        System.out.println("Является ли Петр сотрудником? " + personDataBase.isEmployee(2L));
        System.out.println("Является ли Анна сотрудником? " + personDataBase.isEmployee(3L));


        List<Integer> sortedList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(sortedList);
        System.out.println("Найден элемент 5: " + bst.find(5));
        System.out.println("Найден элемент 10: " + bst.find(10));
        System.out.println("Отсортированный список: " + bst.getSortedList());
    }
}