package com.zhaosoft.example.exam874;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int flg = 0;

        int i = 0, j = 0;
        int res = 0;
        //处理障碍物
        Set<Long> dot = new HashSet<>();
        for (int[] obstacle : obstacles) {
            long ox = (long) obstacle[0] + 30000;
            long oy = (long) obstacle[1] + 30000;
            dot.add((ox << 16) + oy);
        }

        for (int currentCommand : commands) {
            if (currentCommand == -2) { //向左转
                flg = (flg + 3) % 4;

            } else if (currentCommand == -1) { //向右转
                flg = (flg + 1) % 4;
            } else {
                for (int num = 0; num < currentCommand; num++) {
                    int ni = i + dx[flg];
                    int nj = j + dy[flg];
                    if (canGo(ni, nj, dot)) {
                        i = ni;
                        j = nj;
                        res = Math.max(res, i * i + j * j);
                    }
                }
            }

        }
        return res;
    }

    private boolean canGo(int i, int j, Set<Long> dot) {
        long code = (((long) i + 30000) << 16) + ((long) j + 30000);
        if (dot.contains(code)) {
            return false;
        } else {
            return true;
        }
    }
}
