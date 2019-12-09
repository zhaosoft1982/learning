package com.zhaosoft.example.exam169;

import java.util.HashMap;

public class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null) {
            return 0;
        }
        HashMap<Integer, Integer> count = new HashMap<>();
        int length=nums.length/2;
        for (int i : nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
            if (count.get(i) > length) {
                return i;
            }
        }
        return 0;
    }

    public int majorityElement2(int[] nums) {
        int cnt = 1;
        int rst = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (rst == nums[i])
                cnt++;
            else {
                cnt--;
                if (cnt <= 0) {
                    rst = nums[i];
                    cnt = 1;
                }
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3};
        System.out.println(new Solution().majorityElement(nums));
    }
}