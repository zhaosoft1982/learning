package com.zhaosoft.example.exam36;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    /**
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        Set<String> res = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                if (current != '.') {
                    int childIndex = (i / 3) * 3 + j / 3;
                    if (!res.add("R" + i + current) //判断行上是否已经有此数据
                    ||!res.add("C" + j + current)   //判断列是否已经有此数据
                    ||!res.add("z" + childIndex + current)) { //判断所属的子数独是否有重复的值
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        char[][] board={{'8','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}};
        char[][] board={{'.','.','4','.','.','.','6','3','.'},{'.','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','9','.'},{'.','.','.','5','6','.','.','.','.'},{'4','.','3','.','.','.','.','.','1'},{'.','.','.','7','.','.','.','.','.'},{'.','.','.','5','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}};
        Boolean result=new Solution2().isValidSudoku(board);
        System.out.println(result);
    }
}
