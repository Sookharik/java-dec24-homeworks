package ru.otus.java.basic.homeworks.hw18;

import java.util.List;

public interface SearchTree<T extends Comparable<T>> {
    /**
     * @param element to find
     * @return element if exists, otherwise - null
     */
    T find(T element);

    List<T> getSortedList();
}