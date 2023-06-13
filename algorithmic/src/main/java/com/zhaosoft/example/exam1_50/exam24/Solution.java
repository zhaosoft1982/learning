package com.zhaosoft.example.exam1_50.exam24;

import com.zhaosoft.example.ListNode;

/**
 * 24. 两两交换链表中的节点
 * 链表交换相邻元素
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * @param
 * @author xiaoleizhao
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        head = pre;
        while (head.next != null && head.next.next != null) {
            ListNode a = head.next;
            ListNode b = head.next.next;
            head.next = b;
            a.next = b.next;
            b.next = a;
            head = a;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        three.next = four;
        two.next = three;
        one.next = two;
        new Solution().swapPairs(one);
    }
}
