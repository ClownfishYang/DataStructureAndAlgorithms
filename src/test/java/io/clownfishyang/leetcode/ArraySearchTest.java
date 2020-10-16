package io.clownfishyang.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/12 16:01<br>
 */
public class ArraySearchTest {

    @Test
    public void searchInsertTest() {
        ArraySearch arraySearch = new ArraySearch();
        int[] nums = {1,3,5,6};
        Assert.assertEquals(arraySearch.searchInsert(nums, 5),2);
        Assert.assertEquals(arraySearch.searchInsert(nums, 2), 1);
        Assert.assertEquals(arraySearch.searchInsert(nums, 7), 4);
        Assert.assertEquals(arraySearch.searchInsert(nums, 0), 0);
        Assert.assertEquals(arraySearch.searchInsert(nums, 1), 0);
        Assert.assertEquals(arraySearch.searchInsert(nums, 6), 3);
        int[] nums2 = {1,3};
        Assert.assertEquals(arraySearch.searchInsert(nums2, 2), 1);

    }

    @Test
    public void singleNumberTest() {
        ArraySearch arraySearch = new ArraySearch();
        Assert.assertEquals(arraySearch.singleNumber(new int[]{2,2,1}),1);
        Assert.assertEquals(arraySearch.singleNumber(new int[]{4,1,2,1,2}),4);
    }

    @Test
    public void majorityElementTest() {
        ArraySearch arraySearch = new ArraySearch();
        int[] nums = {2, 2, 1};
        Assert.assertEquals(arraySearch.majorityElement(nums, 0, nums.length -1),2);
        nums = new int[]{4,1,2,1,2,1};
        Assert.assertEquals(arraySearch.majorityElement(nums, 0, nums.length -1),1);
    }

    @Test
    public void boyerMooreTest() {
        ArraySearch arraySearch = new ArraySearch();
        int[] nums = {2, 2, 1};
        Assert.assertEquals(arraySearch.boyerMoore(nums),2);
        nums = new int[]{4,1,2,1,2,1};
        Assert.assertEquals(arraySearch.boyerMoore(nums),1);
    }

    @Test
    public void majorityElementMTest() {
        ArraySearch arraySearch = new ArraySearch();
        int[] nums = {3,2,3};
//        System.out.println(arraySearch.majorityElement(nums, 3));
//        nums = new int[]{1,1,1,3,3,2,2,2};
//        System.out.println(arraySearch.majorityElement(nums, 3));
        nums = new int[]{1,2,2,3,2,1,1,3};
//        System.out.println(arraySearch.test(nums));
        System.out.println(arraySearch.boyerMoore2(nums));
    }

    @Test
    public void containsPatternTest() {
        ArraySearch arraySearch = new ArraySearch();
        int[] arr = {1,2,4,4,4,4};
        Assert.assertTrue(arraySearch.containsPattern(arr, 1, 3));
        arr = new int[]{1,2,1,2,1,1,1,3};
        Assert.assertTrue(arraySearch.containsPattern(arr, 2, 2));
        arr = new int[]{1,2,1,2,1,3};
        Assert.assertFalse(arraySearch.containsPattern(arr, 2, 3));
        arr = new int[]{1,2,3,1,2};
        Assert.assertFalse(arraySearch.containsPattern(arr, 2, 2));
        arr = new int[]{2,2,2,2};
        Assert.assertFalse(arraySearch.containsPattern(arr, 2, 3));
        arr = new int[]{2,2};
        Assert.assertTrue(arraySearch.containsPattern(arr, 1, 2));
        arr = new int[]{1,2,1,2,1,3};
        Assert.assertFalse(arraySearch.containsPattern(arr, 2, 3));
    }

    @Test
    public void firstBadVersionTest() {
        ArraySearch arraySearch = new ArraySearch();
        int v = arraySearch.firstBadVersion(5);
        System.out.println(v);

//        v = arraySearch.firstBadVersion(20);
//        System.out.println(v);
    }

    @Test
    public void increasingTripletTest() {
        ArraySearch arraySearch = new ArraySearch();
        int[] nums;
        nums = new int[] {2,5,3,4,5};
        Assert.assertTrue(arraySearch.increasingTriplet(nums));
        nums = new int[] {0,4,2,1,0,-1,-3};
        Assert.assertFalse(arraySearch.increasingTriplet(nums));
        nums = new int[]{1,2,3,4,5};
        Assert.assertTrue(arraySearch.increasingTriplet(nums));
        nums = new int[]{5,4,3,2,1};
        Assert.assertFalse(arraySearch.increasingTriplet(nums));
        nums = new int[]{5,1,5,5,2,5,4};
        Assert.assertTrue(arraySearch.increasingTriplet(nums));
        nums = new int[]{1,2,2,3,3,4};
        Assert.assertTrue(arraySearch.increasingTriplet(nums));
        nums = new int[]{1,2,3};
        Assert.assertTrue(arraySearch.increasingTriplet(nums));
        nums = new int[]{1,2,2,2,3};
        Assert.assertTrue(arraySearch.increasingTriplet(nums));
        nums = new int[]{2,2,2,3,3};
        Assert.assertFalse(arraySearch.increasingTriplet(nums));
        nums = new int[]{5,4,3};
        Assert.assertFalse(arraySearch.increasingTriplet(nums));
    }
}