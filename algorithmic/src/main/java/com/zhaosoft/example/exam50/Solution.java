package com.zhaosoft.example.exam50;

public class Solution {
    /**
     * This is a simple solution based on divide and conquer
     *
     * @param x
     * @param m
     * @return
     */
    public double pow(double x, int m) {
        double temp = x;
        if (m == 0) {
            return 1;
        }

        temp = pow(x, m / 2);
        if (m % 2 == 0) {
            return temp * temp;
        } else {
            if (m > 0) {
                return x * temp * temp;
            } else {
                return (temp * temp) / x;
            }

        }
    }
}
