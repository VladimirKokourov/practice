package ru.vladimirkokourov.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Phone {
    private HashMap<String, Set<String>> phoneBook = new HashMap<>();

    public void add(String name, String phone){
        Set<String> tel = phoneBook.getOrDefault(name, new HashSet<>());
        tel.add(phone);
        phoneBook.put(name, tel);
    }

    public Set<String> get(String name){
        return phoneBook.get(name);
    }
}
