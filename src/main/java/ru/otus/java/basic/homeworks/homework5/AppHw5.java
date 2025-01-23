package ru.otus.java.basic.homeworks.homework5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AppHw5 {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        argument(3, "Hello world");
        integerArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        integerUp(2, arr);
        integerAndLink(1, arr);
        sumHalf(new int[]{9, 8, 7, 6, 5, 4, 4, 9, 9});

    }

    // Task 1 Реализуйте метод, который принимает в качестве аргументов целое число и строку,
    // и выводит в консоль указанную строку указанное количество раз.
    public static void argument(int a, String b) {
        int c = 1;
        while (c <= a) {
            c++;
            System.out.println(b);
        }
    }

    // Task 2 Реализуйте метод, принимающий в качестве аргумента целочисленный массив, суммирующий все элементы,
    // значение которых больше 5, и печатающий полученную сумму в консоль.
    public static void integerArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 5) {
                sum += arr[i];
            }
        }
        System.out.println(sum);
    }

    // Task 3 Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на целочисленный массив,
    // метод должен заполниться каждую ячейку массива указанным числом.
    public static void integerAndLink(int a, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a;
        }
        System.out.println(Arrays.toString(arr));
    }

    // Task 4 Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на целочисленный массив,
    // увеличивающий каждый элемент которого на указанное число.
    public static void integerUp(int a, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += a;
        }
        System.out.println(Arrays.toString(arr));
    }

    // Task 5 Реализуйте метод, принимающий в качестве аргумента целочисленный массив,
    // и печатающий в консоль сумма элементов какой из половин массива больше
    public static void sumHalf(int[] arr) {
        int sumL = 0;
        int sumR = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            sumL += arr[i];
        }
        for (int i = arr.length / 2; i < arr.length; i++) {
            sumR += arr[i];
        }
        if (sumR > sumL) {
            System.out.println("Правая половина больше");
        } else {
            System.out.println("Левая половина больше");
        }
    }
}
