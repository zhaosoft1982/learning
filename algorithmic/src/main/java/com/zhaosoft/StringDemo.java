package com.zhaosoft;

public class StringDemo {
    public String abs(String param) {

        int len = param.length();
        StringBuilder sb = new StringBuilder();
        String word = new String();
        for (int i = len - 1; i >= 0; i--) {
            String temp = param.substring(i, i + 1);
            if (" ".equals(temp)) {
                sb.append(word).append(temp);
                word = "";
            } else {
                word = temp + word;
            }

        }
        sb.append(word);
        return sb.toString();
    }

    public String abs2(String param) {
        int left = 0;
        int right = param.length();

        while (left < right) {
            if (left == 0) {
            }
            left++;
            right--;
        }
        return param;
    }

    public static void main(String[] args) {
        StringDemo stringDemo = new StringDemo();
        String param = "";
        String result = stringDemo.abs2(param);
        System.out.print(result);
        //String result = "one every world hello";
    }
}
