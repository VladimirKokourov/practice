package ru.vladimirkokourov.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionReverseTest {

    private final SolutionReverse solutionReverse = new SolutionReverse();
    
    @Test
    void reverse_shouldBeSuccess() {
        String[] arr1 = {"h", "e", "l", "l", "o", "!"};
        String[] arr2 = {"h", "e", "l", "l", "o"};
        String[] arr3 = {"h", "e"};
        String[] arr4 = {"h"};

        String[] expected1 = {"!", "o", "l", "l", "e", "h"};
        String[] expected2 = {"o", "l", "l", "e", "h"};
        String[] expected3 = {"e", "h"};
        String[] expected4 = {"h"};

        solutionReverse.reverse(arr1);
        solutionReverse.reverse(arr2);
        solutionReverse.reverse(arr3);
        solutionReverse.reverse(arr4);

        assertArrayEquals(expected1, arr1);
        assertArrayEquals(expected2, arr2);
        assertArrayEquals(expected3, arr3);
        assertArrayEquals(expected4, arr4);
    }
}