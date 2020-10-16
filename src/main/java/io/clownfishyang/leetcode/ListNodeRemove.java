package io.clownfishyang.leetcode;

import io.clownfishyang.datastructure.ListNode;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/13 11:33<br>
 */
public class ListNodeRemove {


    /**
     * 功能描述:
     * <p>
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
     * <p>
     * 示例 1：
     * 输入：head = [4,5,1,9], node = 5
     * 输出：[4,1,9]
     * 解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * <p>
     * 示例 2：
     * 输入：head = [4,5,1,9], node = 1
     * 输出：[4,5,9]
     * 解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-03 18:06:13
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 功能描述:
     * <p>
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * <p>
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * <p>
     * 说明：
     * 给定的 n 保证是有效的。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-03 18:06:49
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 快慢指针
        /*ListNode node = head;
        ListNode per = head;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        // 删除头结点
        if (node == null) return per.next;
        // 块指针的下一个节点不为空
        while (node.next != null) {
            per = per.next;
            node = node.next;
        }
        per.next = n == 1 ? null : per.next.next;
        return head;*/
        // 哑结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        ListNode per = dummy;
        for (int i = 0; i <= n; i++) {
            node = node.next;
        }
        // 块指针不为空
        while (node != null) {
            per = per.next;
            node = node.next;
        }
        per.next = n == 1 ? null : per.next.next;
        return dummy.next;
        // 递归计数
//        return removeNode(head, n) == n ? head.next : head;
    }

    public int removeNode (ListNode node, int n) {
        if (node.next == null) return 1;
        // 倒数计数
        int m = removeNode(node.next, n);
        if (m == n) {
            node.next = m == 1 ? null : node.next.next;
        }
        return m + 1;
    }


    /**
     * 功能描述:
     * <p>
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * <p>
     * 示例 1:
     * 输入: 1->1->2
     * 输出: 1->2
     * <p>
     * 示例 2:
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-13 11:43:59
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.next.val == node.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
