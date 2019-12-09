package com.zhaosoft.example;

/**
 * 二叉树的遍历
 *
 * @author xiaoleizhao
 * @date 2018/11/17 10:47
 */
public class BinaryTreeTraversal {
    StringBuffer sb = new StringBuffer();

    public void preOrder(TreeNode treeNode) {
        if (treeNode != null) {
            sb.append(treeNode);
            preOrder(treeNode.left);
            preOrder(treeNode.right);
        }
        System.out.println(sb.toString());
    }

    public void inOrder(TreeNode treeNode) {
        inOrder(treeNode.left);
        sb.append(treeNode);
        inOrder(treeNode.right);
        System.out.println(sb.toString());
    }

    public void postOrder(TreeNode treeNode) {
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        sb.append(treeNode);
        System.out.println(sb.toString());

    }
}
