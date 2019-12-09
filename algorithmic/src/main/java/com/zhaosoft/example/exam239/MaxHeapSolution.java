package com.zhaosoft.example.exam239;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 使用最大堆，理论上来说这个时间复杂度为O(n*k)
 *
 * @author xiaoleizhao
 * @date 2018/11/9 17:22
 */
public class MaxHeapSolution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k <= 0) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if (queue.size() >= k - 1) {
                queue.add(nums[i]);
                result[i - k + 1] = queue.peek();
                queue.remove(nums[i - k + 1]);
            } else {
                queue.add(nums[i]);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = new MaxHeapSolution().maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(result));
    }
}
