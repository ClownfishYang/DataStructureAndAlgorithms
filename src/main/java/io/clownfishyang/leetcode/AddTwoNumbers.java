package io.clownfishyang.leetcode;

import io.clownfishyang.datastructure.ListNode;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author ClownfishYang<br>
 * created on 2020/8/10 18:06<br>
 */
public class AddTwoNumbers {

    /**
     *
     * 功能描述:
     *
     * 同时遍历两个链表，将结果值val 对10 取余则得到当前结果节点的值，将val / 10 则得到进位值，
     * 下次遍历将进位值 + l1.val + l2.val，然后重复取余，整除过程，则得到下个节点的值，以此类推。
     *
     * l1=[0,1]，l2=[0,1,2]	当一个列表比另一个列表长时
     * l1=[]，l2=[0,1]	当一个列表为空时，即出现空列表
     * l1=[9,9]，l2=[1]	求和运算最后可能出现额外的进位，这一点很容易被遗忘
     * @param l1
     * @param l2
     * @return 结果链表
     * @auther ClownfishYang
     * created on 2020-08-10 18:41:20
     */
    public ListNode linearAdd(ListNode l1, ListNode l2) {
        int val = 0;
        // 头结点
        ListNode head = null;
        ListNode listNode = null;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            // 当前值
            ListNode node = new ListNode(val % 10);
            if (head == null) {
                head = node;
            } else {
                listNode.next = node;
            }
            // 指向下个节点
            listNode = node;
            // 进位
            val /= 10;
        }
        // 额外的进位
        if (val != 0) {
            listNode.next = new ListNode(val);
        }
        return head;
    }

}
