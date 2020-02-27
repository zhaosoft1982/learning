package com.zhaosoft;

public class Zipper {
    public String zipString(String iniString) {
        //对字符串进行循环操作
        int oldLength = iniString.length();
        char flg = iniString.charAt(0);
        int len = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < oldLength; i++) {
            char temp = iniString.charAt(i);
            if (flg == temp) {
                len++;
            } else {
                sb.append(flg).append(len);
                len = 1;
                flg = temp;
            }
        }
        sb.append(flg).append(len);
        if (sb.toString().length() < oldLength) {
            return sb.toString();
        } else {
            return iniString;
        }

    }
}
