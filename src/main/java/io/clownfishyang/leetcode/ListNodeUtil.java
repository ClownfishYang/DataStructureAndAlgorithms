package io.clownfishyang.leetcode;

import io.clownfishyang.datastructure.ListNode;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * @author ClownfishYang<br>
 * created on 2020/9/4 10:31<br>
 */
public class ListNodeUtil {


    /**
     *
     * 功能描述:
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
     *
     * 示例 1:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 1->3->5->2->4->NULL
     *
     * 示例 2:
     * 输入: 2->1->3->5->6->4->7->NULL
     * 输出: 2->3->6->7->1->5->4->NULL
     *
     * 说明:
     * 应当保持奇数节点和偶数节点的相对顺序。
     * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-10 10:49:33
     */
    public ListNode oddEvenList(ListNode head) {
        // 节点数小于2
        if (head == null || head.next == null) return head;
        // oddTail 奇链表的尾指针, evenHead evenTail 偶链表的头尾指针
        // oddTail 指向1 指针，evenHead evenTail 指向2 指针
        ListNode oddTail = head, evenHead = head.next, evenTail = evenHead;
        // 从3 开始遍历，一次遍历两个节点
        while (evenTail != null && evenTail.next != null) {
            // 第一个（奇）
            oddTail.next = evenTail.next;
            oddTail = oddTail.next;
            // 第二个（偶）oddTail.next == evenTail.next.next;
            evenTail.next = oddTail.next;
            evenTail = evenTail.next;
        }
        // 奇链表结尾指向偶链表开头
        oddTail.next = evenHead;
        return head;
    }

    /**
     *
     * 功能描述:
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     *
     * 示例:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     *
     * 限制：
     * 0 <= 节点个数 <= 5000
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-04 11:18:11
     */
    public ListNode reverseList(ListNode head) {
        // 双指针
        ListNode cur = null,per = head;
        while (per != null) {
            ListNode next = per.next;
            per.next = cur;
            cur = per;
            per = next;
        }
        return cur;

        // 递归反转
        /*if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        // head -> node, node -> head, 变成环 (head.next 已经不等于 node了，因为之前的node 已经反转好了)
        head.next.next = head;
        // head -> null, 去除head指向，就只剩下node -> head
        head.next = null;
        return node;*/
    }

}
