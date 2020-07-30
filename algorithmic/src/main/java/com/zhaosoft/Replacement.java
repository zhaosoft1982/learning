package com.zhaosoft;

public class Replacement {
    public String replaceSpace(String iniString, int length) {
        // write code here
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            String temp = iniString.substring(i, i + 1);
            if (" ".equals(temp)) {
                sb.append("%20");
            } else {
                sb.append(temp);
            }
        }
        return sb.toString();
    }
}
