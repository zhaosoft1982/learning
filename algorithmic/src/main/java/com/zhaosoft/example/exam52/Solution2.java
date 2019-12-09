package com.zhaosoft.example.exam52;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        //第i个位置存放的数表示row行时，Q的列
        int[] queenList = new int[n];
        //在第0行放Q
        placeQueen(queenList, 0, n, res);
        return res;
    }

    /**
     *
     * @param queenList
     * @param row
     * @param n
     * @param res
     */
    private void placeQueen(int[] queenList, int row, int n, List<List<String>> res) {
        //如果已经填满，就生成结果
        if (row == n) {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = "";
                for (int col = 0; col < n; col++) {
                    if (queenList[i] == col) {
                        str += "Q";
                    } else {
                        str += ".";
                    }
                }
                list.add(str);
            }
            res.add(list);
        }
        for (int col = 0; col < n; col++) {
            //循环每一列
            if (isValid(queenList, row, col)) {
                //如果在该列放入Q不冲突的话
                queenList[row] = col;
                placeQueen(queenList, row + 1, n, res);
            }
        }
    }

    /**
     *
     * @param queenList
     * @param row
     * @param col
     * @return
     */
    private boolean isValid(int[] queenList, int row, int col) {
        for (int i = 0; i < row; i++) {
            int pos = queenList[i];
            // if (pos == col) { //和新加入的Q处于同一列
            //     return false;
            // }
            // if (pos + row - i == col) { //在新加入的Q的右对角线上
            //     return false;
            // }
            // if (pos - row + i == col) { //在新加入的Q的左对角线上
            //     return false;
            // }
            if (col == pos || Math.abs(row - i) == Math.abs(col - pos)) //在同一列或者在同一斜线。一定不在同一行
                return false;

        }
        return true;
    }
}

