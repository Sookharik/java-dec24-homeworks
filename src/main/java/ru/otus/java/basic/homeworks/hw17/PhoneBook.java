package ru.otus.java.basic.homeworks.hw17;

import java.util.*;

public class PhoneBook {

    private Map<String, List<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        if (name == null || phoneNumber == null) {
            throw new IllegalArgumentException("Имя и/или номер телефона не могут быть пустым");
        }
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
        System.out.println("Запись добавлена: " + name + " -> " + phoneNumber);
    }

    public List<String> find(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        return phoneBook.getOrDefault(name, Collections.emptyList());
    }

    public boolean containsPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            throw new IllegalArgumentException("Номер телефона не может быть пустым");
        }
        for (List<String> numbers : phoneBook.values()) {
            if (numbers.contains(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}