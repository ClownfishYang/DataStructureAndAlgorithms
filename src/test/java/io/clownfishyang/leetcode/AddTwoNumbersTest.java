package io.clownfishyang.leetcode;

import io.clownfishyang.datastructure.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/10 18:23<br>
 */
public class AddTwoNumbersTest {

    @Test
    public void linearAddTest() {
//        AddTwoNumbers.ListNode listNode1 = new AddTwoNumbers.ListNode(2);
//        AddTwoNumbers.ListNode listNode2 = new AddTwoNumbers.ListNode(4);
//        AddTwoNumbers.ListNode listNode3 = new AddTwoNumbers.ListNode(3);
//        AddTwoNumbers.ListNode listNode4 = new AddTwoNumbers.ListNode(5);
//        AddTwoNumbers.ListNode listNode5 = new AddTwoNumbers.ListNode(6);
//        AddTwoNumbers.ListNode listNode6 = new AddTwoNumbers.ListNode(4);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;
//
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
//        AddTwoNumbers.ListNode listNode = addTwoNumbers.linearAdd(listNode1, listNode4);
//        System.out.println(listNode);


        ListNode l1 = new ListNode(1);
        ListNode l8 = new ListNode(8);
        ListNode l0 = new ListNode(0);
        l1.next = l8;
        ListNode node = addTwoNumbers.linearAdd(l1, l0);
        System.out.println(node);
    }
}