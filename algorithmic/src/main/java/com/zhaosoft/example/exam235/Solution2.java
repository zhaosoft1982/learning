package com.zhaosoft.example.exam235;

import com.zhaosoft.example.TreeNode;

/**
 * 二叉搜索树，非递归调用情况
 */
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > q.val && root.val > p.val) {
                root = root.left;
            } else if (root.val < q.val && root.val < p.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return root;
    }
}
