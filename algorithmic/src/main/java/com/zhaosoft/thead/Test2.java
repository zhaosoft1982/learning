package com.zhaosoft.thead;

import java.util.concurrent.locks.LockSupport;

public class Test2 {
    static Thread t1 = null;
    static Thread t2 = null;
    static volatile int current = 0;

    public static void main(String[] args) {
        char[] c1 = new char[]{'1', '2', '3', '4'};
        char[] c2 = new char[]{'A', 'B', 'C', 'D'};

        t1 = new Thread(() -> {
            for (char c : c1) {
                while (current == 1) {
                }
                System.out.print(c);
                current = 1;
            }
        }, "t1");

        t2 = new Thread(() -> {
            for (char c : c2) {
                while (current == 0) {
                }
                System.out.print(c);
                current = 0;
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
