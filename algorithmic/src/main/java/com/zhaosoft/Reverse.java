package com.zhaosoft;

public class Reverse {
    public String reverseString(String iniString) {
        // write code here
        char[] chars = iniString.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
