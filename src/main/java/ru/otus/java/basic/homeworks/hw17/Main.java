package ru.otus.java.basic.homeworks.hw17;

public class Main {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов Иван Иванович", "+79999999999");
        phoneBook.add("Петров Петр Петрович", "+76666666666");
        phoneBook.add("Иванов Иван Иванович", "+78888888888");

        System.out.println("Найденные номера для 'Иванов Иван Иванович': " + phoneBook.find("Иванов Иван Иванович"));
        System.out.println("Найденные номера для 'Сидоров Сидор Сидорович': " + phoneBook.find("Сидоров Сидор Сидорович"));

        System.out.println("Номер '+79001234567' существует в справочнике: " + phoneBook.containsPhoneNumber("+79001234567"));
        System.out.println("Номер '+79000000000' существует в справочнике: " + phoneBook.containsPhoneNumber("+79000000000"));
    }
}