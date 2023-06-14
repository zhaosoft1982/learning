package com.zhaosoft.example.exam1_50.exam15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution4 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        //先排序
        Arrays.sort(nums);
        int n = nums.length - 1;
        //遍历到数组倒数第三个数即可
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == 0) {
                if (nums[i + 2] == 0) {
                    ans.add(Arrays.asList(0, 0, 0));
                }
                break;
            }
            //去重，每次循环第一个数都不同（剪枝）
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = n;

            while (left < right) {
                if (nums[left] + nums[right] < -nums[i]) left++;
                else if (nums[left] + nums[right] > -nums[i]) right--;
                else {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    if (nums[left] == nums[right]) break;//去重，后两个相同则结束循环
                    while (left < right && nums[left + 1] == nums[left]) left++; //找到下一个比left大的数
                    left++;
                    while (left < right && nums[right - 1] == nums[right]) right--; //找到下一个比right小的数
                    right--;
                }
            }
        }
        return ans;
    }
}