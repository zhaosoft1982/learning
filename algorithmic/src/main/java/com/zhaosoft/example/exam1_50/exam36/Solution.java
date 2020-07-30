package com.zhaosoft.example.exam1_50.exam36;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 判断一个 9x9 的数独是否有效。
 */
public class Solution {
    /**
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        HashMap<String, Set<Character>> res = new HashMap<>(27);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                if (current != '.') {
                    //判断行上是否已经有此数据
                    if (res.getOrDefault("R" + i, new HashSet()).contains(current)) {
                        return false;
                    } else {
                        Set<Character> temp = res.getOrDefault("R" + i, new HashSet());
                        temp.add(current);
                        res.put("R" + i, temp);
                    }

                    //判断列是否已经有此数据
                    if (res.getOrDefault("C" + j, new HashSet()).contains(current)) {
                        return false;
                    } else {
                        Set<Character> temp = res.getOrDefault("C" + j, new HashSet());
                        temp.add(current);
                        res.put("C" + j, temp);
                    }

                    //判断所属的子数独是否有重复的值
                    int childIndex = (i / 3) * 3 + j / 3;
                    if (res.getOrDefault("z" + childIndex, new HashSet()).contains(current)) {
                        return false;
                    } else {
                        Set<Character> temp = res.getOrDefault("z" + childIndex, new HashSet());
                        temp.add(current);
                        res.put("z" + childIndex, temp);
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
        Boolean result=new Solution().isValidSudoku(board);
        System.out.println(result);
    }
}
