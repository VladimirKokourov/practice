package ru.vladimirkokourov.algorithms;

import java.util.HashMap;
import java.util.Map;

public class SolutionTwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);

                return result;
            }

            map.put(nums[i], i);
        }

        return result;
    }
}
