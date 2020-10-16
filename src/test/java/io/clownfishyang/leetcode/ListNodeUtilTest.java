package io.clownfishyang.leetcode;

import io.clownfishyang.datastructure.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/9/4 10:34<br>
 */
public class ListNodeUtilTest {

    @Test
    public void reverseListTest() {
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        ListNode listNode = ListNode.build(1, 2, 3);
        ListNode reverseList = listNodeUtil.reverseList(listNode);
        System.out.println(reverseList.str());
    }

    @Test
    public void oddEvenListTest() {
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        ListNode listNode = ListNode.build(1, 2, 3, 4, 5);
        ListNode reverseList = listNodeUtil.oddEvenList(listNode);
        System.out.println(reverseList.str());
    }
}