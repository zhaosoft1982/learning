package com.zhaosoft.example.exam874;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        char flg = 't'; //'l','d','r'
        int[][] root = new int[][]{{0, 0}};
        int[][] pos = new int[][]{{0, 0}};
        int i = 0, j = 0;
        int len = 0;
        //处理障碍物
        Set<String> dot = new HashSet();
        for (int x = 0; x < obstacles.length; x++) {
            dot.add(obstacles[x][0] + ":" + obstacles[x][1]);
        }

        while (len < commands.length) {
            int currentCommand = commands[len];
            if (currentCommand==-2) { //向左转
                if (flg == 't') {
                    flg = 'l';
                } else if (flg == 'l') {
                    flg = 'd';
                } else if (flg == 'd') {
                    flg = 'r';
                } else if (flg == 'r') {
                    flg = 't';
                }
            } else if (currentCommand==-1) { //向右转
                if (flg == 't') {
                    flg = 'r';
                } else if (flg == 'l') {
                    flg = 't';
                } else if (flg == 'd') {
                    flg = 'l';
                } else if (flg == 'r') {
                    flg = 'd';
                }
            } else {
                for (int num = 0; num < currentCommand; num++) {
                    if (flg == 't' && canGo(i, j + 1, dot)) {
                        j++;
                    } else if (flg == 'd' && canGo(i, j - 1, dot)) {
                        j--;
                    } else if (flg == 'l' && canGo(i - 1, j, dot)) {
                        i--;
                    } else if (flg == 'r' && canGo(i + 1, j, dot)) {
                        i++;
                    } else {
                        break;
                    }
                }
            }
            System.out.println(len++);
        }
        return i * i + j * j;
    }

    private boolean canGo(int i, int j, Set<String> dot) {
        if (dot.contains(i + ":" + j)) {
            System.out.println("撞上障碍物："+i + ":" + j);
            return false;
        } else {
            return true;
        }
    }
}
