package io.clownfishyang.datastructure;

import io.clownfishyang.leetcode.MergeLists;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * 单链表
 *
 * @author ClownfishYang<br>
 * created on 2020/8/11 15:35<br>
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode build(int... vals) {
        return build(null, vals);
    }

    public static ListNode build(ListNode tailNode, int... vals) {
        ListNode listNode = new ListNode();
        if (vals.length > 0) {
            listNode.val = vals[0];
            ListNode node = listNode;
            for (int i = 1; i < vals.length; i++) {
                node.next = new ListNode(vals[i]);
                node = node.next;
            }
            node.next = tailNode;
        }
        return listNode;
    }

    public String str() {
        StringBuilder sb = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            if (sb.length() != 0) {
                sb.append("->");
            }
            sb.append(node.val);
            node = node.next;
        }
        return sb.toString();
    }
}
