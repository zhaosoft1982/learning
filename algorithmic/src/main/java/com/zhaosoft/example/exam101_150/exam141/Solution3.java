package com.zhaosoft.example.exam101_150.exam141;

import com.zhaosoft.example.ListNode;

public class Solution3 {
    /**
     * 特殊的快慢指针
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode fast = head.next.next;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null)
                return false;
            else if (fast == slow || fast.next == slow)
                return true;
            else {
                fast = fast.next.next;
                slow = slow.next;
            }
        }
    }
}
