package com.zhaosoft.test.example.exam806;

import java.util.HashMap;
import java.util.Map;

/**
 * 柠檬水找零
 * [5,5,5,10,20]
 */
public class Solution {
    public boolean lemonadeChange1(int[] bills) {
        if (bills.length < 1) {
            return true;
        }
        if (bills[0] == 10 || bills[0] == 20) {
            return false;
        }
        int fiveCount = 0;
        int tenCount = 0;
        int twentyCount = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveCount++;
            }
            if (bills[i] == 10) {
                if (fiveCount > 0) {
                    fiveCount--;
                    tenCount++;
                } else {
                    return false;
                }
            }
            if (bills[i] == 20) {
                if (tenCount > 0) {
                    if (fiveCount > 0) {
                        tenCount--;
                        fiveCount--;
                        twentyCount++;
                    } else {
                        return false;
                    }
                } else {
                    if (fiveCount > 3) {
                        fiveCount = fiveCount - 3;
                        twentyCount++;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean lemonadeChange(int[] bills) {
        if (bills.length < 1) {
            return true;
        }
        if (bills[0] == 10 || bills[0] == 20) {
            return false;
        }
        int fiveCount = 0;
        int tenCount = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveCount++;
            } else if (bills[i] == 10) {
                if (fiveCount <= 0) {
                    return false;
                }
                fiveCount--;
                tenCount++;
            } else {
                if (tenCount > 0 && fiveCount > 0) {
                    tenCount--;
                    fiveCount--;
                } else if (fiveCount >= 3) {
                    fiveCount = fiveCount - 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
