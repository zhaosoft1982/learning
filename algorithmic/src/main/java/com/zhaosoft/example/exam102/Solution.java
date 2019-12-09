package com.zhaosoft.example.exam102;

import com.zhaosoft.example.TreeNode;

import java.util.*;

/**
 * 广度优先搜索，遍历树节点
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        //Set visited=new HashSet();

        while (!q.isEmpty()){
            int levelSize=q.size();
            List<Integer> currentLevel=new ArrayList<>();

            for(int i=0;i<levelSize;i++){
                TreeNode currNode=q.poll();
                currentLevel.add(currNode.val);

                if(currNode.left!=null){
                    q.add(currNode.left);
                }

                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;

    }
}
