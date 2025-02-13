package ru.otus.java.basic.homeworks.hw12;

/**
 * Реализуйте классы Тарелка (максимальное количество еды, текущее количество еды) и Кот (имя, аппетит).
 * Количество еды измеряем в условных единицах.
 * <p>
 * При создании тарелки указывается ее объем и она полностью заполняется едой
 * В тарелке должен быть метод, позволяющий добавить еду в тарелку. После добавления в тарелке не может оказаться еды больше максимума
 * В тарелке должен быть boolean метод уменьшения количества еды, при этом после такого уменьшения,
 * в тарелке не может оказаться отрицательное количество еды (если удалось уменьшить еду так, чтобы в тарелке осталось >= 0 кусков еды,
 * то возвращаем true, в противном случае - false).
 * Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
 * Если коту удалось покушать (хватило еды), сытость = true.
 * Считаем, что если коту мало еды в тарелке, то он её просто не трогает,
 * то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
 * Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
 */
public class Plate {
    private int maxFood;
    private int amountFood;

    public Plate(int maxFood) {
        this.maxFood = maxFood;
        this.amountFood = maxFood;
    }

    void addFood(int amount) {
        if (amount <= 0) {
            System.out.println("Количество еды должно быть положительным.");
            return;
        }
        int temp = amountFood + amount;
        if (temp > maxFood) {
            System.out.println("Нельзя добавить еды. Тарелка переполнится!");
            System.out.println("Максимальная вместимость: " + maxFood);
        } else {
            amountFood += amount;
            System.out.println("Еда увеличилась на " + amount);
            System.out.println("Еды в миске " + amountFood);
        }
    }

    boolean decreaseFood(int amount) {
        if (amount <= 0) {
            System.out.println("Количество еды должно быть положительным.");
            return false;
        }
        if (amountFood >= amount) {
            amountFood -= amount;
            System.out.println("Еда уменьшилась на " + amount);
            System.out.println("Еды в миске " + amountFood);
            return true;
        } else {
            System.out.println("Недостаточно еды в тарелке. Требуется: " + amount);
            System.out.println("Еды в миске " + amountFood);
            return false;
        }
    }

    void info() {
        System.out.println("Максимальная вместимость: " + maxFood);
        System.out.println("Еды в миске " + amountFood);
    }
}