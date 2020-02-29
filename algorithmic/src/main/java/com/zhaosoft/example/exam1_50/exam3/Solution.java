package com.zhaosoft.example.exam1_50.exam3;

import com.zhaosoft.example.ListNode;

/**
 * 反转链表
 *
 * @param
 * @author xiaoleizhao
 * @date 2018/11/1 22:30
 * @return
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode newCurrent = current.next;
            current.next = pre;
            pre = current;
            current = newCurrent;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode newCurrent = head.next;
            head.next = pre;
            pre = head;
            head = newCurrent;
        }
        return pre;
    }

    public ListNode reverseList3(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        head.next = null;
        return pre;
    }
}
