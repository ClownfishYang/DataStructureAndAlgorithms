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
 * created on 2020/8/10 17:43<br>
 */
public class TwoSumTest {

    @Test
    public void hashContainsTest() {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        Assert.assertTrue(Arrays.equals(twoSum.hashContains(nums, 9), new int[]{0, 1}));
        Assert.assertTrue(Arrays.equals(twoSum.hashContains(nums, 13), new int[]{0, 2}));
    }

    @Test
    public void binarySearchTest() {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        Assert.assertTrue(Arrays.equals(twoSum.binarySearch(nums, 9), new int[]{1, 2}));
        Assert.assertTrue(Arrays.equals(twoSum.binarySearch(nums, 13), new int[]{1, 3}));
        Assert.assertTrue(Arrays.equals(twoSum.binarySearch(nums, 26), new int[]{3, 4}));
        try {
            twoSum.binarySearch(nums, 27);
        } catch (IllegalArgumentException e) {
        }
        nums = new int[]{1,2,3,4,4,9,56,90};
        Assert.assertTrue(Arrays.equals(twoSum.binarySearch(nums, 8), new int[]{4, 5}));
    }

    @Test
    public void tailHeadSearchTest() {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        Assert.assertTrue(Arrays.equals(twoSum.tailHeadSearch(nums, 9), new int[]{1, 2}));
        Assert.assertTrue(Arrays.equals(twoSum.tailHeadSearch(nums, 13), new int[]{1, 3}));
        Assert.assertTrue(Arrays.equals(twoSum.tailHeadSearch(nums, 26), new int[]{3, 4}));
        try {
            twoSum.tailHeadSearch(nums, 27);
        } catch (IllegalArgumentException e) {
        }
        nums = new int[]{1,2,3,4,4,9,56,90};
        Assert.assertTrue(Arrays.equals(twoSum.tailHeadSearch(nums, 8), new int[]{4, 5}));
    }

}