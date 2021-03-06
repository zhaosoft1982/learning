package com.zhaosoft;

public class Transform {
    public int[][] transformImage(int[][] mat, int n) {

        if (mat == null) {
            return null;
        }

        int temp = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                temp = mat[i][j];
                mat[i][j] = mat[n - j - 1][n - i - 1];
                mat[n - j - 1][n - i - 1] = temp;
            }
        }

        for (int i = 0; i < (n / 2); ++i) {
            for (int j = 0; j < n; ++j) {
                temp = mat[i][j];
                mat[i][j] = mat[n - i - 1][j];
                mat[n - i - 1][j] = temp;
            }

        }

        return mat;

    }
}
