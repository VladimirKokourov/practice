package ru.vladimirkokourov.generics.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {

    private final List<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    private List<T> getFruits() {
        return fruits;
    }

    public double getWeight() {
        return fruits.stream().mapToDouble(Fruit::getWeight).sum();
    }

    public void put(T fruit) {
        fruits.add(fruit);
    }

    public void put(T... fruit) {
        fruits.addAll(Arrays.asList(fruit));
    }

    public void putAll(Box<T> box) {
        fruits.addAll(box.getFruits());
        box.fruits.clear();
    }

    public <E extends Fruit> boolean compare(Box<E> box) {
        return getWeight() == box.getWeight();
    }

    @Override
    public String toString() {
        return fruits.toString();
    }
}
