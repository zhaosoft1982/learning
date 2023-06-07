package com.zhaosoft.example.exam101_150.exam141;

import com.zhaosoft.example.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class Solution2 {
    /**
     * 我们遍历所有结点并在哈希表中存储每个结点的引用（或内存地址）。如果当前结点为空结点 null（即已检测到链表尾部的下一个结点），
     * 那么我们已经遍历完整个链表，并且该链表不是环形链表。如果当前结点的引用已经存在于哈希表中，那么返回 true（即该链表为环形链表）。
     * <p>
     * 复杂度分析
     * 时间复杂度：O(n)， 对于含有 n个元素的链表，我们访问每个元素最多一次。添加一个结点到哈希表中只需要花费 O(1) 的时间。
     * 空间复杂度：O(n)， 空间取决于添加到哈希表中的元素数目，最多可以添加 n个元素。
     *
     * @param head
     * @return boolean
     * @author xiaoleizhao
     * @date 2018/11/3 19:34
     */
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
