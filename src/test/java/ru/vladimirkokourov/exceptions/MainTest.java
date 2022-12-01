package ru.vladimirkokourov.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void sum_shouldBeSuccess() {
        String[][] arr = {
                {"4", "8", "9", "5"},
                {"7", "8", "9", "1"},
                {"7", "2", "2", "3"},
                {"8", "9", "9", "1"}
        };
        int expected = 92;
        assertEquals(expected, Main.sum(arr));
    }

    @Test
    void sum_ShouldThrowMyArrayDataException() {
        String[][] arr = {
                {"4", "8", "9", "5"},
                {"7", "8f", "9", "1"},
                {"7", "2", "2", "3"},
                {"8", "9", "9", "1"}
        };
        assertThrows(MyArrayDataException.class, () -> Main.sum(arr));
    }

    @Test
    void sum_ShouldThrowMyArraySizeException() {
        String[][] arr = {
                {"4", "8", "9", "5"},
                {"7", "8", "9", "1"},
                {"7", "2", "2", "3"},
                {"8", "9", "9"}
        };
        assertThrows(MyArraySizeException.class, () -> Main.sum(arr));
    }
}