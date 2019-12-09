package com.zhaosoft.example.exam141;

import com.zhaosoft.example.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class Solution2 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (nodeSet.contains(head)) {
                return true;
            } else {
                nodeSet.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
