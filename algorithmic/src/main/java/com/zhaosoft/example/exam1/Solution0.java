package com.zhaosoft.example.exam1;

import java.util.Arrays;
import java.util.HashMap;

public class Solution0 {
    public int[] twoSum(int[] sums, int target) {
        for (int i = 0; i < sums.length; i++) {
            for (int j = i + 1; j < sums.length; j++) {
                if (sums[i] + sums[j] == target) {
                    return new int[]{i, j};
                }
            }

        }

        return null;
    }


    public static void main(String[] args) {
        Solution0 solution = new Solution0();
        int[] nums = new int[]{9, 11, 2, 7, 11, 6, 4, 1, 10, 15};
        int[] result = solution.twoSum(nums, 9);
        System.out.print(Arrays.toString(result));
    }
}
