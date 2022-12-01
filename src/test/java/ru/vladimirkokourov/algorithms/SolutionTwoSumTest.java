package ru.vladimirkokourov.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTwoSumTest {

    private final SolutionTwoSum sum = new SolutionTwoSum();

    @Test
    void twoSum_shouldBeSuccess() {
        int[] nums1 = {3, 2, 3};
        int[] nums2 = {3, 2, 4};
        int[] nums3 = {3, 3};

        int[] expected1 = {0, 2};
        int[] expected2 = {1, 2};
        int[] expected3 = {0, 1};

        assertArrayEquals(expected1, sum.twoSum(nums1, 6));
        assertArrayEquals(expected2, sum.twoSum(nums2, 6));
        assertArrayEquals(expected3, sum.twoSum(nums3, 6));
    }
}