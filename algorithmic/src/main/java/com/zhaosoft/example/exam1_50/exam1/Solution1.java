package com.zhaosoft.example.exam1_50.exam1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class Solution1 {
    public int[] twoSum(int[] sums, int target) {
        HashMap<Integer, Integer> tempHashMap = new HashMap<>(sums.length);

        for (int i = 0; i < sums.length; i++) {
            Integer temValue = target - sums[i];
            if (tempHashMap.containsKey(temValue)) {
                return new int[]{i, tempHashMap.get(temValue).intValue()};
            } else {
                tempHashMap.put(sums[i], i);
            }
        }

        return null;
    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = new int[]{9, 11, 2, 7, 11, 6, 4, 1, 10, 15};
        int[] result = solution.twoSum(nums, 9);
        System.out.print(Arrays.toString(result));
    }
}
