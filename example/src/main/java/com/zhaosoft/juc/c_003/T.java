package com.zhaosoft.juc.c_003;

/**
 * @author xiaoleizhao
 * @create 2019-12-19 16:57
 **/
public class T {
    private int count = 10;

    public synchronized void m() { //等同于在方法的代码执行时要synchronized(this)
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }
}

