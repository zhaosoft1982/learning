package com.zhaosoft.example.exam239;

import java.util.Arrays;

public class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length < 1 || k == 0) {
            return new int[0];
        }

        int max = 0;
        int size = nums.length - k + 1;
        int[] result = new int[size];
        //首先获取首个窗口，并拿到最大值
        for (int j = 0; j < k; j++) {
            if (nums[j] > max) {
                max = nums[j];
            }
        }
        result[0] = max;
        for (int i = 1; i < size; i++) {
            if (max == nums[i - 1]) {
                max = nums[i];
                for (int j = 0; j < k; j++) {
                    if (nums[j + i] > max) {
                        max = nums[j + i];
                    }
                }
            } else if (nums[i + k - 1] > nums[i - 1] && nums[i + k - 1] > max) {
                max = nums[i + k - 1];
            }

            result[i] = max;

        }

        return result;
    }

    public static void main(String [] args){
        int[] nums = new int[]{7,1,3,-1,-3,5,3,6,7};
        int[] result= new Solution().maxSlidingWindow(nums,3);
        System.out.println(Arrays.toString(result));
    }
}
