package io.clownfishyang.datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/24 15:34<br>
 */
public class ListNodeTest {

    @Test
    public void buildTest() {
        ListNode listNode = ListNode.build(3, 2, 0, 4);
        listNode.next.next.next.next = listNode.next;
        System.out.println(listNode);

    }
}