package ru.vladimirkokourov.collections;

import java.util.*;

public class Phone {
    private final Map<String, Set<String>> phoneBook = new HashMap<>();

    public void add(String name, String phone) {
        if (phoneBook.containsKey(name)) {
            Set<String> strings = phoneBook.get(name);
            strings.add(phone);
        } else {
            Set<String> strings = new HashSet<>();
            strings.add(phone);
            phoneBook.put(name, strings);
        }
    }

    public Set<String> get(String name) {
        return Collections.unmodifiableSet(phoneBook.get(name));
    }
    
}
