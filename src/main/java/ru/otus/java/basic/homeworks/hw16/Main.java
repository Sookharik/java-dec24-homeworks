package ru.otus.java.basic.homeworks.hw16;

import java.util.*;

/**
 * Реализуйте метод, принимающий в качестве аргументов числа min и max, и возвращающий ArrayList с набором последовательных значений в указанном диапазоне (min и max включительно, шаг - 1);
 * Реализуйте метод, принимающий в качестве аргумента список целых чисел, суммирующий все элементы, значение которых больше 5, и возвращающий сумму;
 * Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список, метод должен переписать каждую заполненную ячейку списка указанным числом;
 * Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список, увеличивающий каждый элемент списка на указанное число;
 * Создайте класс Сотрудник с полями: имя, возраст;
 * Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий список их имен;
 * Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный возраст, и возвращающий список сотрудников, возраст которых больше либо равен указанному аргументу;
 * Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный средний возраст, и проверяющий что средний возраст сотрудников превышает указанный аргумент;
 * Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий ссылку на самого молодого сотрудника.
 */
public class Main {
    public static void main(String[] args) {
        int min = 1;
        int max = 22;
        int minAge = 33;
        int midAge = 22;

        ArrayList<Integer> list = generateRange(min, max);

        System.out.println(list);

        System.out.println(sumList(list));

        increase(min, list);

        record(min, list);

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Mark", 22));
        employees.add(new Employee("Aleks", 33));
        employees.add(new Employee("Tom", 44));

        System.out.println(employeeNames(employees));

        for (Employee employee : filterEmployeesByAge(employees, minAge)) {
            System.out.println("Name: " + employee.getName() + ", Age: " + employee.getAge());
        }

        boolean result = averageAgeValue(employees, midAge);
        System.out.println("Средний возраст больше минимального: " + result);

        Employee youngest = findYoungestEmployee(employees);
        if (youngest != null) {
            System.out.println("Самый молодой сотрудник: " + youngest.getName() + ", возраст: " + youngest.getAge());
        } else {
            System.out.println("Список сотрудников пуст.");
        }
    }

    static ArrayList<Integer> generateRange(int a, int b) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = a; i <= b; i++) {
            result.add(i);
        }
        return result;
    }

    static int sumList(List<Integer> list) {
        int sum = 0;
        for (Integer number : list) {
            if (number > 5) {
                sum += number;
            }
        }
        return sum;
    }

    static void record(int a, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, a);
        }
        System.out.println(list);
    }

    static void increase(int a, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + a);
        }
        System.out.println(list);
    }

    static List<String> employeeNames(List<Employee> employees) {
        List<String> names = new ArrayList<>();
        for (Employee employee : employees) {
            names.add(employee.getName());
        }
        return names;
    }

    static List<Employee> filterEmployeesByAge(List<Employee> employees, int minAge) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() >= minAge) {
                result.add(employee);
            }
        }
        return result;
    }

    static boolean averageAgeValue(List<Employee> employees, double minAverageAge) {
        int totalAge = 0;
        for (Employee employee : employees) {
            totalAge += employee.getAge();
        }
        double averageAge = (double) totalAge / employees.size();
        return averageAge > minAverageAge;
    }

    static Employee findYoungestEmployee(List<Employee> employees) {
        Employee youngest = employees.get(0);
        for (Employee employee : employees) {
            if (employee.getAge() < youngest.getAge()) {
                youngest = employee;
            }
        }
        return youngest;
    }
}