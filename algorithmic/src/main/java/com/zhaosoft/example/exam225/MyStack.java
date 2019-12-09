package com.zhaosoft.example.exam225;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 先进后出
 */
class MyStack {

    /**
     * 先进先出
     */
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int top;


    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        top=x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int tempValue;
        while(q1.size()>1){
            top = q1.poll();
            q2.add(top);
        }
        tempValue =q1.poll();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return tempValue;
    }

    /** Get the top element. */
    public int top() {
       return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(q1.isEmpty() && q2.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
