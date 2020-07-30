package com.zhaosoft.example.exam557;

import java.util.Stack;

public class Solution {
    Stack<String> stack = new Stack<String>();

    public String reverseWords1(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(temp);
            } else if (i == s.length() - 1) {
                stack.push(temp + "");
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            } else {
                stack.push(temp + "");
            }
        }

        return sb.toString();
    }

    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String str : arr) {
            StringBuilder temp = new StringBuilder(str).reverse();
            res.append(temp).append(" ");
        }
        return res.toString().trim();
    }
}
