package com.zhaosoft.example.exam50_100.exam98;

import com.zhaosoft.example.exam50_100.TreeNode;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        // current value, default long min value
        long[] current = {Long.MIN_VALUE};
        int[] flag = new int[1];   // flag
        func(root, current, flag);
        return flag[0] == 0;
    }

    private void func(TreeNode root, long[] current, int[] flag) {
        // root is null or not satisfy (fast fail)
        if (root == null || flag[0] == 1) return;
        func(root.left, current, flag);
        if (current[0] >= root.val) flag[0] = 1;   // not satisfy
        current[0] = root.val;  // update current value
        func(root.right, current, flag);
    }
}
