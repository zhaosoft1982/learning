package com.zhaosoft.juc.c_002;

/**
 * @author xiaoleizhao
 * @create 2019-12-19 16:56
 **/
public class T {
    private int count = 10;

    public void m() {
        //任何线程想要执行那个下面的代码，必须先要拿到this的锁
        synchronized(this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

}

