package com.zhaosoft.example.exam1_50.exam15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0, len = nums.length; i < len - 2; i++) {
            int j = i + 1;
            int k = len - 1;
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
                int compareResult = nums[i] + nums[j] + nums[k];
                if (compareResult < 0)
                    j++;
                else if (compareResult > 0)
                    k--;
                else {
                    List<Integer> oneResult = new ArrayList<>(3);
                    oneResult.add(nums[i]);
                    oneResult.add(nums[j++]);
                    oneResult.add(nums[k--]);
                    result.add(oneResult);
                    while (j < k && nums[j] == nums[j - 1]){
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]){
                        k--;
                    }
                }
            }
        }
        return result;


    }
}
