package com.zhaosoft.structures;

/**
 * 数字实现队列
 */
public class ArrayQueue {
    /**
     * 数组：items，数组大小：n
     */
    private String[] items;
    private int n = 0;

    /**
     * head 表示队头下标，tail 表示队尾下标
     */
    private int head = 0;
    private int tail = 0;

    /**
     * 申请一个大小为 capacity 的数组
     *
     * @param capacity
     */
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;

    }

    /**
     * 入队
     *
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        if (tail == n) {
            if(head==0){
                return false;
            }
            //数据移动
            for(int i=head;i<tail;i++){
                items[i-head]=items[i];
            }
            tail=tail-head;
            head=0;
        }
        items[tail] = item;
        tail = tail + 1;
        return true;
    }

    /**
     * @return
     */
    public String dequeue() {
        if (tail == head) {
            return null;
        }
        String result = items[head];
        head = head + 1;
        return result;
    }

}
