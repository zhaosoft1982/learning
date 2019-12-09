package com.zhaosoft.example.exam239;

import java.util.Arrays;

public class Solution3 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(len == 0) return new int[0];

        int[] res = new int[len-k+1];

        for(int i = 0;i<len-k+1; i++){
            int max =Integer.MIN_VALUE;
            for(int j = i;j<i+k;j++){
                max = Math.max(nums[j],max);
            }
            res[i] = max;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = new Solution3().maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(result));
    }
}
