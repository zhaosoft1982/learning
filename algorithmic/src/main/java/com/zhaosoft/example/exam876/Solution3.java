package com.zhaosoft.example.exam876;

import com.zhaosoft.example.ListNode;

public class Solution3 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
