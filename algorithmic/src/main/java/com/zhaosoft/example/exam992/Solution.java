package com.zhaosoft.example.exam992;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int subarraysWithKDistinct0(int[] A, int K) {
        if (A == null) {
            return 0;
        }
        int result = 0;
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (i <= A.length - K) {
            for (int j = i; j < A.length; j++) {
                set.add(A[j]);
                if (j - i + 1 >= K) {
                    if (set.size() == K) {
                        result++;
                    } else if (set.size() > K) {
                        break;
                    }
                }
            }
            set.clear();
            i++;
        }
        return result;
    }

    /**
     * 1,2,1,2,3
     *
     * @param A
     * @param K
     * @return
     */
    public int subarraysWithKDistinct(int[] A, int K) {
        Window window1 = new Window();
        Window window2 = new Window();
        int ans = 0, left1 = 0, left2 = 0;

        for (int right = 0; right < A.length; ++right) {
            int x = A[right];
            window1.add(x);
            window2.add(x);

            while (window1.getCount() > K) {
                window1.remove(A[left1++]);
            }

            while (window2.getCount() >= K) {
                window2.remove(A[left2++]);
            }

            ans += left2 - left1;
        }

        return ans;
    }
}
