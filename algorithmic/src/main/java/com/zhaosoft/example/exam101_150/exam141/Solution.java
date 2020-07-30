package com.zhaosoft.example.exam101_150.exam141;

import com.zhaosoft.example.ListNode;

/**
 * 给定一个链表，判断链表中是否有环。
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String [] args){
        ListNode head=new ListNode(1);
        ListNode three=new ListNode(3);
        ListNode five=new ListNode(5);
        three.next=five;
        head.next=three;

        new com.zhaosoft.example.exam101_150.exam141.Solution().hasCycle(head);
    }
}
