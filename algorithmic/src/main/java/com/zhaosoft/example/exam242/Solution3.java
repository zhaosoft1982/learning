package com.zhaosoft.example.exam242;

import java.util.Arrays;

public class Solution3 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sa = s.toCharArray();
        Arrays.sort(sa);

        char[] ta = t.toCharArray();
        Arrays.sort(ta);

        return Arrays.equals(sa, ta);
    }

    public static void main(String [] args){
        System.out.println(new Solution3().isAnagram("anagram","nagaram"));
    }
}
