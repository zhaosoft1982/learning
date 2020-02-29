package com.zhaosoft.example.exam1_50.exam15;

import java.util.*;

public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if (nums.length == 0) {
            return new ArrayList<>(res);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0 || (nums[i] + nums[j] + nums[j+1])>0){
                break;
            }
            if (nums[i] + nums[k] + nums[k - 1] < 0) {
                continue;
            }
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                    while (j < k && nums[j] == nums[j - 1]){
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]){
                        k--;
                    }
                } else if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                }
            }

        }
        return new ArrayList<>(res);

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        //new int[]{1, 2, -2, -1};
        //new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> resutl = new Solution2().threeSum(nums);
    }
}
