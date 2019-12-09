package com.zhaosoft.example.exam703;

import java.util.PriorityQueue;

public class KthLargest2 {
    private int[] heap;
    private int k;
    private int size;

    public KthLargest2(int k, int[] nums) {
        this.k = k;
        heap = new int[k + 1];
        for (int a : nums) {
            add(a);
        }
    }

    public int add(int val) {
        if (size < k) {
            heap[++size] = val;
            for (int i = size; i > 1 && heap[i] < heap[i >>> 1]; ) {
                swap(i, i >>>= 1);
            }
        } else if (val > heap[1]) {
            // If val is greater than the minimum then it replaces the minimum.
            // Otherwise it's ignored.
            heap[1] = val;
            // Move val to the bottom.
            sink();
        }
        return heap[1];
    }

    private void sink() {
        int i = 1;
        while (i << 1 <= size) {
            // 2i and 2i+1 are the children of i.
            int j = i << 1;
            // If 2i+1 exists, choose the smallest of 2i and 2i+1.
            if (j < size && heap[j + 1] < heap[j]) j++;
            // If there are no children less than i then we're done.
            if (heap[i] <= heap[j]) break;
            // Otherwise swap i and the smallest of its children.
            swap(i, i = j);
        }
    }

    private void swap(int i, int j) {
        int t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }
}
