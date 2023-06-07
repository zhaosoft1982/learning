package com.zhaosoft.example.exam101_150.exam141;

import com.zhaosoft.example.ListNode;

/**
 * 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false
 */
public class Solution {
    /**
     * 复杂度分析
     * 时间复杂度：O(n)O(n)， 让我们将 nn 设为链表中结点的总数。为了分析时间复杂度，我们分别考虑下面两种情况。
     * 链表中不存在环：
     * 快指针将会首先到达尾部，其时间取决于列表的长度，也就是 O(n)O(n)。
     * 链表中存在环：
     * 我们将慢指针的移动过程划分为两个阶段：非环部分与环形部分：
     * 慢指针在走完非环部分阶段后将进入环形部分：此时，快指针已经进入环中 \text{迭代次数} = \text{非环部分长度} = N迭代次数=非环部分长度=N
     * 两个指针都在环形区域中：考虑两个在环形赛道上的运动员 - 快跑者每次移动两步而慢跑者每次只移动一步。其速度的差值为1，因此需要经过 \dfrac{\text{二者之间距
     * }}{\text{速度差值}}
     * 速度差值二者之间距离次循环后，快跑者可以追上慢跑者。这个距离几乎就是 "\text{环形部分长度 K}环形部分长度 K" 且速度差值为 1，
     * 我们得出这样的结论 \text{迭代次数} =\text{近}迭代次数=近似于 "\text{环形部分长度 K}环形部分长度 K".
     * 因此，在最糟糕的情形下，时间复杂度为 O(N+K)，也就是 O(n)。
     * 空间复杂度：O(1)， 我们只使用了慢指针和快指针两个结点，所以空间复杂度为 O(1)。
     *
     * @param head
     * @return
     */
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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode three = new ListNode(3);
        ListNode five = new ListNode(5);
        three.next = five;
        head.next = three;

        new com.zhaosoft.example.exam101_150.exam141.Solution().hasCycle(head);
    }
}
