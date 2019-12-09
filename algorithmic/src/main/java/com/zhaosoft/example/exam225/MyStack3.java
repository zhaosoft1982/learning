package com.zhaosoft.example.exam225;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack3 {
    Queue<Integer> q1=new LinkedList();

    public void push(int x){
        q1.add(x);
        int size=q1.size();
        while (size > 1) {
            q1.add(q1.remove());
            size--;
        }
    }

    public int pop(){
        return q1.remove();
    }

    public int top(){
        return q1.peek();
    }

    public boolean isEmpty(){
        return q1.isEmpty();
    }
}
