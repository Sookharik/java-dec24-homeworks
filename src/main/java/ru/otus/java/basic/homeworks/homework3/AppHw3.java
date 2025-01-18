package ru.otus.java.basic.homeworks.homework3;

import java.util.Scanner;

public class AppHw3 {
    public static void main(String[] args) {

        enterTheNumber();
    }

    // task (*) При запуске приложения, запросите у пользователя число от 1 до 5, и после ввода выполнения метод,
    // соответствующий указанному номеру со случайным значением аргументов;
    public static void enterTheNumber() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int rnd1 = (int) (Math.random() * 10);
            int rnd2 = (int) (Math.random() * 10);
            System.out.println("Введите число от 1 до 5");
            int difficulty = scanner.nextInt();
            if (difficulty == 1) {
                greetings();
            } else if (difficulty == 2) {
                checkSign(rnd1, rnd2, -10);
            } else if (difficulty == 3) {
                selectColor();
            } else if (difficulty == 4) {
                compareNumbers(rnd1, rnd2);
            } else if (difficulty == 5) {
                addOrSubtractAndPrint(rnd1, rnd2, true);
            }
        }
    }

    // task (1) Реализуйте метод greetings(), который при вызове должен отпечатать в столбец 4 слова: Hello, World, from, Java;
    public static void greetings() {
        System.out.println("Hello");
        System.out.println("World");
        System.out.println("from");
        System.out.println("Java");
    }

    // task (2) Реализуйте метод checkSign(..), принимающий в качестве аргументов 3 int переменные a, b и c.
    // Метод должен посчитать их сумму, и если она больше или равна 0, то вывести в консоль сообщение “Сумма положительная”,
    // в противном случае - “Сумма отрицательная”;
    public static void checkSign(int a, int b, int c) {
        int sum = a + b + c;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // task (3) Реализуйте метод selectColor() в теле которого задайте int переменную data с любым начальным значением.
    // Если data меньше 10 включительно, то в консоль должно быть выведено сообщение “Красный”,
    // если от 10 до 20 включительно, то “Желтый”, если больше 20 - “Зеленый”;
    public static void selectColor() {
        System.out.println("Для отображения Красного цвета введите число от 1 до 10 включительно");
        System.out.println("Для отображения Желтого цвета введите число от 1 до 20 включительно");
        System.out.println("Для отображения Зеленого цвета введите число больше 20");
        Scanner scanner = new Scanner(System.in);
        int data = scanner.nextInt();
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data > 20) {
            System.out.println("Зеленый");
        } else {
            System.out.println("Желтый");
        }
    }

    // task (4) Реализуйте метод compareNumbers(), в теле которого объявите две int переменные a и b с любыми начальными значениями.
    // Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
    public static void compareNumbers(int a, int b) {
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    // task (5) Создайте метод addOrSubtractAndPrint(int initValue, int delta, boolean increment). Если increment = true,
    // то метод должен к initValue прибавить delta и отпечатать в консоль результат, в противном случае - вычесть;
    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment == true) {
            System.out.println(initValue + delta);
        } else {
            System.out.println(initValue - delta);
        }
    }
}
