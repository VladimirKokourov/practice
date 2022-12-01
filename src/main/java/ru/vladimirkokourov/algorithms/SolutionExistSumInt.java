package ru.vladimirkokourov.algorithms;

import java.util.HashMap;
import java.util.Map;

public class SolutionExistSumInt {

//    Example 2: Given a sorted array of unique integers and a target integer, return true if there exists a pair
//    of numbers that sum to target, false otherwise. This problem is similar to Two Sum.
//
//    For example, given nums = [1, 2, 4, 6, 8, 9, 14, 15] and target = 13, return true because 4 + 9 = 13.

    public boolean existSum(int[] nums, int target) {

        int pLeft = 0;
        int pRight = nums.length - 1;

        while (pLeft < pRight) {
            int sum = nums[pLeft] + nums[pRight];

            if (sum == target) {
                return true;
            } else if (sum > target) {
                pRight--;
            } else {
                pLeft++;
            }
        }

        return false;
    }

    public boolean existSumWithHashMap(int[] arr, int sum) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            if (map.containsKey(sum - arr[i])) {
                return true;
            }

            map.put(arr[i], i);
        }

        return false;
    }
}
