package com.zhaosoft.example;

public class ArrayStack {
    private String[] items; // 数组
    private int count; // 栈中元素个数
    private int n; // 栈的大小

    // 初始化数组，申请一个大小为 n 的数组空间
    public ArrayStack(int n) {
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    public boolean push(String item) {
        if (count == n) return false;
        items[count] = item;
        ++count;

        return true;
    }

    public String pop() {
        if (count == 0) return null;
        String temp = items[count - 1];
        --count;
        return temp;
    }

}
