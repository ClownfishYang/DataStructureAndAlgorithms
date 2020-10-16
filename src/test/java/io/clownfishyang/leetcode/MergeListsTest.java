package io.clownfishyang.leetcode;

import io.clownfishyang.datastructure.ListNode;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/11 16:00<br>
 */
public class MergeListsTest {

    @Test
    public void linearMergeTest() {
        ListNode l1 = ListNode.build(1, 2, 3);
        ListNode l2 = ListNode.build(1, 4, 5);

        MergeLists mergeLists = new MergeLists();
        System.out.println(mergeLists.linearMerge(l1, l2).str());
        System.out.println(mergeLists.linearMerge(null, null));
        System.out.println(mergeLists.linearMerge(null, new ListNode()).str());
    }

    @Test
    public void linearHeadMergeTest() {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3, n = 3;
        MergeLists mergeLists = new MergeLists();
        int[] nums = mergeLists.linearHeadMerge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void linearTailMergeTest() {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3, n = 3;
        MergeLists mergeLists = new MergeLists();
        int[] nums = mergeLists.linearTailMerge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums));
    }
}