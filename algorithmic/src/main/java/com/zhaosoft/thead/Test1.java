package com.zhaosoft.thead;

import java.util.concurrent.locks.LockSupport;

public class Test1 {
    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {
        char[] c1 = new char[]{'1', '2', '3', '4'};
        char[] c2 = new char[]{'A', 'B', 'C', 'D'};

        t1 = new Thread(() -> {
            for (char c : c1) {
                System.out.print(c);
                LockSupport.unpark(t2);
                LockSupport.park();

            }
        }, "t1");

        t2 = new Thread(() -> {
            for (char c : c2) {
                LockSupport.park();
                System.out.print(c);
                LockSupport.unpark(t1);
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
