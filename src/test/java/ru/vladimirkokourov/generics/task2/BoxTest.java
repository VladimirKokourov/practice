package ru.vladimirkokourov.generics.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {

    @Test
    void getWeight_and_put() {
        Apple apple = new Apple();
        Box<Apple> box = new Box<>();
        box.put(apple);
        double expected = apple.getWeight();

        assertEquals(expected, box.getWeight());
    }
}