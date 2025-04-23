package ru.otus.java.basic.homeworks.hw18;

public class SortingUtils {

    public static void bubbleSort(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив не может быть пустым");
        }

        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {22, 11, 55, 00, 66, 99, 77};

        System.out.println("Исходный массив:");
        printArray(array);

        bubbleSort(array);

        System.out.println("Отсортированный массив:");
        printArray(array);
    }
}