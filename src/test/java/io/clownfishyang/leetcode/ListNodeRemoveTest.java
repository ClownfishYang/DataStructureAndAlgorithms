package io.clownfishyang.leetcode;

import io.clownfishyang.datastructure.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/13 11:36<br>
 */
public class ListNodeRemoveTest {

    @Test
    public void deleteDuplicatesTest() {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode listNode5 = new ListNode(1);
        ListNode listNode6 = new ListNode(1);
        ListNode listNode7 = new ListNode(2);
        ListNode listNode8 = new ListNode(3);
        ListNode listNode9 = new ListNode(3);
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;

        ListNodeRemove nodeRemove = new ListNodeRemove();
//        System.out.println(nodeRemove.deleteDuplicates(listNode1).toString());
        System.out.println(nodeRemove.deleteDuplicates(listNode5).str());
    }

    @Test
    public void deleteNodeTest() {
        ListNodeRemove nodeRemove = new ListNodeRemove();
        ListNode listNode = null;

        listNode = ListNode.build(1);
        listNode = nodeRemove.removeNthFromEnd(listNode, 1);
        System.out.println("listNode : " + listNode);

        listNode = ListNode.build(1, 2, 3, 4, 5);
        listNode = nodeRemove.removeNthFromEnd(listNode, 2);
        System.out.println(listNode.str());

        listNode = ListNode.build(1,2);
        listNode = nodeRemove.removeNthFromEnd(listNode, 1);
        System.out.println(listNode.str());

        listNode = ListNode.build(1,2);
        listNode = nodeRemove.removeNthFromEnd(listNode, 2);
        System.out.println(listNode.str());
    }
}