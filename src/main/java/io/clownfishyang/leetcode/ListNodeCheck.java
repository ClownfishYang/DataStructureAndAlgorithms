package io.clownfishyang.leetcode;

import io.clownfishyang.datastructure.ListNode;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/24 15:19<br>
 */
public class ListNodeCheck {

    /**
     *
     * 功能描述:
     * 给定一个链表，判断链表中是否有环。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     *
     * 示例 1：
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     *
     * 示例 2：
     * 输入：head = [1,2], pos = 0
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     *
     * 示例 3：
     * 输入：head = [1], pos = -1
     * 输出：false
     * 解释：链表中没有环。
     *
     * 使用快慢指针进行，若存在环，则快指针会追上慢指针，否则，则指针的next 为null。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-24 15:30:45
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     *
     * 功能描述:
     *
     * 找到两个单链表相交的起始节点。
     *
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Reference of the node with value = 8
     * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B
     * 中，相交节点前有 3 个节点。
     *
     * 通过双指针的方式，分别初始化A 和B 的头结点，逐结点向后遍历，当p1 达到尾部时，将p1 指向B 的头结点，p2 类似。
     * 即比较遍历的链表为A+B 和B+A,因为两个链表相加节点数相等，若存在交点，则必定会相遇，否则最终都将指向null。
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-24 16:55:10
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }


}
