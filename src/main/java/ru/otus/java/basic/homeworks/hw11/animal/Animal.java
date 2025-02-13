package ru.otus.java.basic.homeworks.hw11.animal;

/**
 * Создайте классы Cat, Dog и Horse с наследованием от класса Animal
 * У каждого животного есть имя, скорость бега и плавания (м/с), и выносливость (измеряется в условных единицах)
 * Затраты выносливости:
 * Все животные на 1 метр бега тратят 1 ед выносливости,
 * Собаки на 1 метр плавания - 2 ед.
 * Лошади на 1 метр плавания тратят 4 единицы
 * Кот плавать не умеет.
 * Реализуйте методы run(int distance) и swim(int distance), которые должны возвращать время,
 * затраченное на указанное действие, и “понижать выносливость” животного. Если выносливости не хватает,
 * то возвращаем время -1 и указываем что у животного появилось состояние усталости.
 * При выполнении действий пишем сообщения в консоль.
 * <p>
 * Добавляем метод info(), который выводит в консоль состояние животного.
 */

public class Animal {
    String name;
    double runSpeed;
    double swimSpeed;
    double endurance;//выносливость
    double time;
    String speedUnit = "м/с";
    String enduranceUnit = "у.е.";
    String timeUnit = "секунд";
    int swimIndex = 1;

    public double run(int distance) {
        if (endurance < (distance * 1)) {
            info();
            System.out.println("Животное устало");
            return time = -1;
        }
        endurance = endurance - (distance * 1);
        time = distance / runSpeed;
        info();
        return time;
    }

    public double swim(int distance) {
        if (endurance < (distance * swimIndex)) {
            info();
            System.out.println("Животное устало");
            return time = -1;
        }
        endurance = endurance - (distance * swimIndex);
        time = distance / swimSpeed;
        info();
        return time;
    }

    public void info() {
        System.out.println();
        System.out.println(name);
        System.out.println("Выносливость: " + endurance + " " + enduranceUnit);
        System.out.println("Скорость бега: " + runSpeed + " " + speedUnit);
        System.out.println("Скорость плаванья: " + swimSpeed + " " + speedUnit);
        System.out.println("Преодолел(а) дистанцию за " + time + " " + timeUnit);
    }
}