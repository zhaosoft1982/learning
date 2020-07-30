package com.zhaosoft;

import java.util.Arrays;

public class Same {
    public boolean checkSam(String stringA, String stringB) {
        // write code here
        char[] charsA = stringA.toCharArray();
        char[] charsB = stringB.toCharArray();
        Arrays.sort(charsA);
        Arrays.sort(charsB);
        String a = Arrays.toString(charsA);
        String b = Arrays.toString(charsB);
        if (a.equals(b)) {
            return true;
        }
        return false;
    }
}
