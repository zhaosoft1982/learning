package com.zhaosoft.example.exam232;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> input=new Stack();
    Stack<Integer> output=new Stack();
    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(output.isEmpty()){
            while (!input.isEmpty()){
                output.push(input.pop());
            }
            return output.pop();
        }else{
            return output.pop();
        }
    }

    /** Get the front element. */
    public int peek() {
        if(output.isEmpty()){
            while (!input.isEmpty()){
                output.push(input.pop());
            }
            return output.peek();
        }else{
            return output.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(output.isEmpty()){
            while (!input.isEmpty()){
                output.push(input.pop());
            }
            return output.isEmpty();
        }else{
            return false;
        }
    }
}
