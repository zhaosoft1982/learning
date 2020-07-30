package com.zhaosoft;

public class Different {
    public boolean checkDifferent(String iniString) {
        // write code here
        char[] chars = iniString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
