package ru.vladimirkokourov.collections;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void findFrequencies() {
        HashMap<String, Integer> expected = new HashMap<>();
        String[] words = {"cat", "dog", "red", "bad", "cat"};

        expected.put("cat", 2);
        expected.put("dog", 1);
        expected.put("red", 1);
        expected.put("bad", 1);

        assertEquals(expected, Main.findFrequencies(words));
    }
}