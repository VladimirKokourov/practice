package ru.vladimirkokourov.generics.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwapTest {

    @Test
    void process() {
        String[] arr = new String[]{"str1", "str2", "str3"};
        String[] expected = new String[]{"str3", "str2", "str1"};

        Swap.process(arr, 0, 2);

        assertArrayEquals(expected, arr);
    }
}