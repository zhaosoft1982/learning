package com.zhaosoft.example.exam860;

import java.util.HashMap;
import java.util.Map;

/**
 * 柠檬水找零
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * [5,5,5,10,20]
 */
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        //临界值，如果没有账单不需要找零
        if (bills.length < 1) {
            return true;
        }
        //如果第一个是10元或20元，无法找零
        if (bills[0] == 10 || bills[0] == 20) {
            return false;
        }
        int fiveCount = 0;
        int tenCount = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveCount++;
            } else if (bills[i] == 10) {
                if (fiveCount > 0) {
                    fiveCount--;
                    tenCount++;
                } else {
                    return false;
                }
            } else if (bills[i] == 20) {
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
