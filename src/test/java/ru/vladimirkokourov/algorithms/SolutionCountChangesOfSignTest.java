package ru.vladimirkokourov.algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionCountChangesOfSignTest {

    private final SolutionCountChangesOfSign sign = new SolutionCountChangesOfSign();

    @Test
    void countChangesOfSign_shouldBeSuccess() {
        int[] arr1 = {1, 0, 5, 1};
        int[] arr2 = {1, 0, -5, -1};
        int[] arr3 = {-1, 0, 1, -5, 1};

        assertEquals(0, sign.countChangesOfSign(arr1));
        assertEquals(1, sign.countChangesOfSign(arr2));
        assertEquals(3, sign.countChangesOfSign(arr3));
    }
}