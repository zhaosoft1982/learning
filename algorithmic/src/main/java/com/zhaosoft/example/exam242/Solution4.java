package com.zhaosoft.example.exam242;

public class Solution4 {
    public boolean isAnagram(String s, String t) {

        if (s == null || t == null)
            return  false;
        if (s.length() != t.length())
            return  false;

        int[] sIntArray = new int[26];

        for (char c : s.toCharArray()) {
            sIntArray[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            sIntArray[c - 'a']--;
        }

        for (int i = 0; i < sIntArray.length; i++) {
            if (sIntArray[i] > 0)
                return false;
        }
        return true;


    }
}
