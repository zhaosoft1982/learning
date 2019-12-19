package com.zhaosoft.juc.c_004;

/**
 * @author xiaoleizhao
 * @create 2019-12-19 16:58
 **/
public class T {
    private static int count = 10;

    public synchronized static void m() { //这里等同于synchronized(T.class)
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void mm() {
        //考虑一下这里写synchronized(this)是否可以？
        synchronized(T.class) {
            count --;
        }
    }
}

