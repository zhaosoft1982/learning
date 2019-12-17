package com.zhaosoft.example;

import javax.sound.midi.Soundbank;

public class Solution {
    public int abc(int m, int n) {
        int[][] res = new int[m][n];
        res[0][0] = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[0][j] = 1;
                res[i][0] = 1;
                res[i][j] = res[i - 1][j] + res[i][j - 1];
                System.out.println(res[i][j]);
            }
        }
        return res[m - 1][n - 1];
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.abc(8, 7));
    }
}
