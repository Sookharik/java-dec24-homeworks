package ru.otus.java.basic.homeworks.HW7;

import java.util.Arrays;

public class AppHw7 {

    public static void main(String[] args) {
        int[][] intArray = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        sumOfPositiveElements(intArray);
        printSquare(4);
        diagonalZeroing(intArray);
        findMax(intArray);
        sumTwoLine(intArray);
        System.out.println(sumTwoLine(intArray));
    }

    /**
     * Реализовать метод sumOfPositiveElements(..), принимающий в качестве аргумента целочисленный двумерный массив,
     * метод должен посчитать и вернуть сумму всех элементов массива, которые больше 0;
     */

    public static void sumOfPositiveElements(int[][] intArray) {
        int sumStr = 0;
        int sumArrays = 0;
        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j < intArray[i].length; j++) {
                if (intArray[i][j] > 0) {
                    sumStr += intArray[i][j];
                }
            }
        }
        sumArrays += sumStr;
        System.out.println(sumArrays);
    }

    /**
     * Реализовать метод, который принимает в качестве аргумента int size и печатает в консоль квадрат из символов *
     * со сторонами соответствующей длины;
     */

    public static void printSquare(int size) {
        char[][] array = new char[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = '*';
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Реализовать метод, принимающий в качестве аргумента двумерный целочисленный массив,
     * и зануляющий его диагональные элементы (можете выбрать любую из диагоналей, или занулить обе);
     */

    public static void diagonalZeroing(int[][] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j < intArray[i].length; j++) {
                intArray[i][i] = 0;
                intArray[i][intArray.length - 1 - i] = 0;
                System.out.print(intArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Реализовать метод findMax(int[][] array) который должен найти и вернуть максимальный элемент массива;
     */

    public static void findMax(int[][] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        System.out.println(max);
    }

    /**
     * Реализуйте метод, который считает сумму элементов второй строки двумерного массива,
     * если второй строки не существует, то в качестве результата  необходимо вернуть -1
     */

    public static int sumTwoLine(int[][] array) {
        if (array.length < 2) {
            return -1;
        } else {
            int sumStr = 0;
            for (int i = 0; i < array[1].length; i++) {
                sumStr += array[1][i];
            }
            return sumStr;
        }
    }
}
