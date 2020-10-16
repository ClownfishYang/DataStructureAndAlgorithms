package io.clownfishyang.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/11 16:55<br>
 */
public class ArrayRemoveTest {

    @Test
    public void linearRemoveDuplicatesTest() {
        ArrayRemove arrayRemove = new ArrayRemove();
        int[] nums1 = {1,1,2};
        int len1 = arrayRemove.linearRemoveDuplicates(nums1);
        Assert.assertEquals(len1, 2);
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        int len2 = arrayRemove.linearRemoveDuplicates(nums2);
        Assert.assertEquals(len2, 5);
        System.out.println(Arrays.toString(nums2));
    }

    @Test
    public void removeElementByCopyTest() {
        ArrayRemove arrayRemove = new ArrayRemove();
        int[] nums1 = {1,1,2};
        int len1 = arrayRemove.removeElementByCopy(nums1, 2);
        Assert.assertEquals(len1, 2);
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        int len2 = arrayRemove.removeElementByCopy(nums2, 1);
        Assert.assertEquals(len2, 7);
        System.out.println(Arrays.toString(nums2));
        int[] nums3 = {3,2,2,3};
        int len3 = arrayRemove.removeElementByCopy(nums3, 3);
        Assert.assertEquals(len3, 2);
        System.out.println(Arrays.toString(nums3));
        int[] nums4 = {0,1,2,2,3,0,4,2};
        int len4 = arrayRemove.removeElementByCopy(nums4, 2);
        Assert.assertEquals(len4, 5);
        System.out.println(Arrays.toString(nums4));
//        int[] nums5 = {1,2};
//        int len5 = arrayRemove.removeElementByCopy(nums5, 3);
//        Assert.assertEquals(len5, 0);
//        System.out.println(Arrays.toString(nums5));
    }

    @Test
    public void removeElementByChangeTest() {
        ArrayRemove arrayRemove = new ArrayRemove();
        int[] nums1 = {1,1,2};
        int len1 = arrayRemove.removeElementByChange(nums1, 2);
        Assert.assertEquals(len1, 2);
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        int len2 = arrayRemove.removeElementByChange(nums2, 1);
        Assert.assertEquals(len2, 7);
        System.out.println(Arrays.toString(nums2));
        int[] nums3 = {3,2,2,3};
        int len3 = arrayRemove.removeElementByChange(nums3, 3);
        Assert.assertEquals(len3, 2);
        System.out.println(Arrays.toString(nums3));
        int[] nums4 = {0,1,2,2,3,0,4,2};
        int len4 = arrayRemove.removeElementByChange(nums4, 2);
        Assert.assertEquals(len4, 5);
        System.out.println(Arrays.toString(nums4));
//        int[] nums5 = {1,2};
//        int len5 = arrayRemove.removeElementByCopy(nums5, 3);
//        Assert.assertEquals(len5, 0);
//        System.out.println(Arrays.toString(nums5));
    }
}