package com.zhaosoft.example.exam703;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest3 {
//    class MaxComparator implements Comparator<Integer> {
//        public int compare(Integer x, Integer y){
//            return y-x;
//        }
//    }

    private PriorityQueue<Integer> pq;
    private int k ;

    private void addToPQ(int val){
        if(pq.size() < k) pq.add(val);
        else{
            if(pq.peek() < val){
                pq.poll();
                pq.add(val);
            }
        }
    }


    public KthLargest3(int k, int[] nums) {
        this.k=k;
        pq = new PriorityQueue<>(k);
        for(int x: nums)
            addToPQ(x);
    }

    public int add(int val) {
        addToPQ(val);
        return pq.peek();
    }

    public static  void main(String[] args){
        int [] nums=new int[]{8,5,3,9};
        KthLargest3 k=new KthLargest3(3,nums);

        System.out.println(k.add(6));

        System.out.println(k.add(10));
    }
}

