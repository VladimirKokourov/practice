package ru.vladimirkokourov.collections;

import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {

    private static Phone phone = new Phone();

    @Test
    void add_and_get() {
        Set<String> expected = new HashSet<>();
        expected.add("123");
        expected.add("321");

        phone.add("Name", "123");
        phone.add("Name", "321");

        assertEquals(expected, phone.get("Name"));
    }
}