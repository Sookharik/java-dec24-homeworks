package ru.otus.java.basic.homeworks.hw18;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PersonDataBase {
    private HashMap<Long, Person> personHashMap;
    private Set<Position> managerPositions;

    public PersonDataBase() {
        personHashMap = new HashMap<>();

        managerPositions = new HashSet<>(Set.of(
                Position.MANAGER,
                Position.DIRECTOR,
                Position.SENIOR_MANAGER,
                Position.BRANCH_DIRECTOR));
    }

    public Person findById(Long id) {
        return personHashMap.get(id);
    }

    public void add(Person person) {
        if (person != null && person.id != null) {
            personHashMap.put(person.id, person);
        } else {
            throw new IllegalArgumentException("Пользователь или его идентификатор не могут быть пустыми");
        }
    }

    public boolean isManager(Person person) {
        if (person == null || person.position == null) {
            throw new IllegalArgumentException("Пользователь или его позиция не могут быть пустыми");
        }
        return managerPositions.contains(person.position);
    }

    public boolean isEmployee(Long id) {
        Person person = personHashMap.get(id);
        if (person == null || person.position == null) {
            throw new IllegalArgumentException("Пользователь с указанным идентификатором не найден или его позиция не определена");
        }
        return !managerPositions.contains(person.position);
    }
}