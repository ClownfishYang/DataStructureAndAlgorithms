package io.clownfishyang.leetcode;

import io.clownfishyang.datastructure.ListNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/24 15:40<br>
 */
public class ListNodeCheckTest {

    @Test
    public void hasCycleTest() {
        ListNodeCheck listNodeCheck = new ListNodeCheck();
        ListNode listNode = ListNode.build(3, 2, 0, 4);
        Assert.assertFalse(listNodeCheck.hasCycle(listNode));
        listNode.next.next.next = listNode.next;
        Assert.assertTrue(listNodeCheck.hasCycle(listNode));

        listNode = ListNode.build(1);
        Assert.assertFalse(listNodeCheck.hasCycle(listNode));
    }

    @Test
    public void getIntersectionNodeTest() {
        ListNode l3 = ListNode.build(3, 2, 1);

        ListNode l1 = ListNode.build(l3, 1,2);
        ListNode l2 = ListNode.build(l3, 6,5,4);

        ListNodeCheck listNodeCheck = new ListNodeCheck();
        ListNode node = listNodeCheck.getIntersectionNode(l1, l2);
        System.out.println(node);
    }
}