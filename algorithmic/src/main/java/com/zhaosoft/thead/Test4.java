package com.zhaosoft.thead;

public class Test4 {
    static Object lock = new Object();
    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {
        char[] c1 = new char[]{'1', '2', '3', '4'};
        char[] c2 = new char[]{'A', 'B', 'C', 'D'};

        t1 = new Thread(() -> {
            synchronized (lock) {
                for (char c : c1) {
                    System.out.print(c);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                }
                lock.notify();
            }
        }, "t1");

        t2 = new Thread(() -> {
            synchronized (lock) {
                for (char c : c2) {
                    System.out.print(c);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                }
                lock.notify();
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
