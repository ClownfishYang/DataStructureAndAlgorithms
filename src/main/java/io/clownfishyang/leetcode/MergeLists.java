package io.clownfishyang.leetcode;

import io.clownfishyang.datastructure.ListNode;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/11 15:34<br>
 */
public class MergeLists {

    /**
     *
     * 功能描述:
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     *
     * 示例：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-04 11:41:45
     */
    public ListNode linearMerge(ListNode l1, ListNode l2) {
        // 递归
        /*if (l1 == null && l2 == null)
            return null;
        if (l1 != null && l2 == null)
            return l1;
        if (l1 == null && l2 != null)
            return l2;
        if (l1.val < l2.val) {
            l1.next = linearMerge(l1.next, l2);
            return l1;
        } else {
            l2.next = linearMerge(l1, l2.next);
            return l2;
        }*/
        // 线性合并
        if (l1 == null && l2 == null)
            return null;
        ListNode head = new ListNode(), cur = head;
        while (l1 != null && l2 != null) {
            ListNode temp;
            if (l1.val < l2.val) {
                temp = l1;
                l1 = l1.next;
            } else {
                temp = l2;
                l2 = l2.next;
            }
            cur.next = temp;
            cur = temp;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return head.next;
    }

    public int[] linearHeadMerge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m];
        System.arraycopy(nums1, 0, nums, 0, m);

        int p1 = 0;
        int p2 = 0;
        int p = 0;

        while ((p1 < m) && (p2 < n)) {
            nums1[p++] = (nums[p1] < nums2[p2]) ? nums[p1++] : nums2[p2++];
        }
        if (p1 < m) {
            System.arraycopy(nums, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
        return nums1;
    }

    public int[] linearTailMerge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = nums1.length - 1;

        while ((p1 >= 0) && (p2 >= 0)) {
            nums1[p--] = (nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--];
        }
        // nums1 剩余的已经有序,只要复制nums2 的到nums1 即可
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        return nums1;
    }

}
