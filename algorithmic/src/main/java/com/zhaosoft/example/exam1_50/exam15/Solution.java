package com.zhaosoft.example.exam1_50.exam15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个整数数组 nums
 * 判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 请你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if ((nums[i] + nums[j] + nums[k]) == 0) {
                        //初始化结果容器
                        List<Integer> temp = new ArrayList<>(3);
                        temp.add(i);
                        temp.add(j);
                        temp.add(k);
                        //排序，防止出现重复的情况
                        Collections.sort(temp);
                        if (!result.contains(temp)) {
                            result.add(temp);
                        }
                    }
                }
            }

        }
        return result;
    }


}
