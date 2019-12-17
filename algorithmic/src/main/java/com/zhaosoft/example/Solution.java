package com.zhaosoft.example;

import javax.sound.midi.Soundbank;

public class Solution {
    public int abc(int m, int n) {
        int[][] res = new int[m][n];
        res[0][0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0||j==0){
                    res[i][j] = 1;
                }else {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                }

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
