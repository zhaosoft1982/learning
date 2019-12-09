package com.zhaosoft.example.exam239;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
/**
 *
 * @author xiaoleizhao
 * @date 2018/11/9 17:48
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int [] result=new int[nums.length-k+1];

        for(int i=0;i<nums.length;i++){
            // 每当新数进来时，如果发现队列头部的数的下标，是窗口最左边数的下标，则扔掉
            if(!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.poll();
            }
            // 把队列尾部所有比新数小的都扔掉，保证队列是降序的
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.removeLast();
            }

            // 加入新数
            deque.offerLast(i);
            // 队列头部就是该窗口内第一大的
            if((i + 1) >= k){
                result[i + 1 - k] = nums[deque.peek()];
            }

        }
        return result;
    }

    public static void main(String [] args){
       int[] nums = new int[]{7,1,3,-1,-3,5,3,6,7};
       int[] result= new Solution().maxSlidingWindow(nums,3);
       System.out.println(Arrays.toString(result));
    }
}
