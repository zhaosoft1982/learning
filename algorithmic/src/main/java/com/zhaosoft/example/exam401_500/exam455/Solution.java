package com.zhaosoft.example.exam401_500.exam455;

import java.util.Arrays;

public class Solution {
    /**
     * @param g 小朋友
     * @param s 饼干
     * @return
     */
    public int findContentChildren0(int[] g, int[] s) {
        if (g == null || s == null) return 0;
        int result = 0;
        for (int i = 0; i < s.length; i++) { //拿出每一块饼干
            int current = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < g.length; j++) { //拿饼干i，跟小朋友j做比对，分给最适合的小朋友s[i]=g[j];
                if (g[j] != 0) {
                    int currentTemp = s[i] - g[j];
                    if (currentTemp >= 0 && currentTemp < current) {
                        current = currentTemp;
                        index = j;
                    }
                }
            }
            if (index >= 0) {
                g[index] = 0;
                result++;
            }
        }
        return result;
    }

    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) return 0;
        Arrays.sort(g);  //排序很重要，不然下面的循环无法实现功能
        Arrays.sort(s);
        int j = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] >= g[j]) {
                j++; //小朋友得到饼干
                if (j >= g.length) {
                    return j;
                }
            }
        }
        return j;
    }
}
