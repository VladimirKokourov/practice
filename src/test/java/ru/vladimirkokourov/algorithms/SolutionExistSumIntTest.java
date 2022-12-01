package ru.vladimirkokourov.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionExistSumIntTest {

    private final SolutionExistSumInt solutionExistSumInt = new SolutionExistSumInt();

    @Test
    void existSum_shouldBeSuccess_checkTrueWithNegativeNumbers() {
        int[] arr = {-5, -4, -3, -2, -1};
        int sum = -6;

        assertTrue(solutionExistSumInt.existSum(arr, sum));
    }

    @Test
    void existSum_shouldBeSuccess_checkFalseWithNegativeNumbers() {
        int[] arr = {-5, -4, -3, -2};
        int sum = -3;

        assertFalse(solutionExistSumInt.existSum(arr, sum));
    }

    @Test
    void existSum_shouldBeSuccess_checkTrueWithTwoNumbers() {
        int[] arr = {1, 2};
        int sum = 3;

        assertTrue(solutionExistSumInt.existSum(arr, sum));
    }

    @Test
    void existSum_shouldBeSuccess_checkFalseWithTwoNumbers() {
        int[] arr = {0, 2};
        int sum = 3;

        assertFalse(solutionExistSumInt.existSum(arr, sum));
    }

    @Test
    void existSum_shouldBeSuccess_checkTrue() {
        int[] arr = {1, 2, 4, 6, 8, 9, 14};
        int sum = 13;

        assertTrue(solutionExistSumInt.existSum(arr, sum));
    }

    @Test
    void existSum_shouldBeSuccess_checkFalse() {
        int[] arr = {1, 2, 3, 6, 8, 9, 14};
        int sum = 13;

        assertFalse(solutionExistSumInt.existSum(arr, sum));
    }

    @Test
    void existSumWithHashMap_shouldBeSuccess_checkTrue() {
        int[] arr = {1, 2, 4, 6, 8, 9, 14};
        int sum = 13;

        assertTrue(solutionExistSumInt.existSum(arr, sum));
    }

    @Test
    void existSumWithHashMap_shouldBeSuccess_checkFalse() {
        int[] arr = {1, 2, 3, 6, 8, 9, 14};
        int sum = 13;

        assertFalse(solutionExistSumInt.existSum(arr, sum));
    }

    @Test
    void existSumWithHashMap_shouldBeSuccess_checkTrueWithNegativeNumbers() {
        int[] arr = {-5, -4, -3, -2, -1};
        int sum = -6;

        assertTrue(solutionExistSumInt.existSumWithHashMap(arr, sum));
    }

    @Test
    void existSumWithHashMap_shouldBeSuccess_checkFalseWithNegativeNumbers() {
        int[] arr = {-5, -4, -3, -2};
        int sum = -3;

        assertFalse(solutionExistSumInt.existSumWithHashMap(arr, sum));
    }
}