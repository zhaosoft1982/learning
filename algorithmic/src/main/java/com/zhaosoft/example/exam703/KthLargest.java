package com.zhaosoft.example.exam703;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> queue;
    private int k;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue(k);
        this.k=k;
        for(int a:nums){
            add(a);
        }
    }

    public int add(int val) {
        if(queue.size()<k){
            queue.offer(val);
        }else{
           if(queue.peek()<val){
               queue.poll();
               queue.offer(val);
           }
        }
        return queue.peek();
    }

    public static  void main(String[] args){
        int [] nums=new int[]{8,5,3,9};
        KthLargest k=new KthLargest(3,nums);

        System.out.println(k.add(6));

        System.out.println(k.add(10));
    }
}
