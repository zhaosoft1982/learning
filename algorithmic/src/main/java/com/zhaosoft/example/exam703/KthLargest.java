package com.zhaosoft.example.exam703;

import java.util.PriorityQueue;

/**
 * 703. 数据流中的第 K 大元素
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * <p>
 * 请实现 KthLargest 类：
 * <p>
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 */
public class KthLargest {
    PriorityQueue<Integer> queue;
    private int k;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue(k);
        this.k = k;
        for (int a : nums) {
            add(a);
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.offer(val);
        } else {
            if (queue.peek() < val) {
                queue.poll();
                queue.offer(val);
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 5, 3, 9};
        KthLargest k = new KthLargest(3, nums);

        System.out.println(k.add(6));

        System.out.println(k.add(10));
    }
}
