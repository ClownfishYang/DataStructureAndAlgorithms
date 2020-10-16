package io.clownfishyang.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/12 18:03<br>
 */
public class ArraySumTest {

    @Test
    public void maxSubArrayTest() {
        ArraySum arraySum = new ArraySum();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Assert.assertEquals(arraySum.maxSubArray(nums), 6);
    }

    @Test
    public void maxSubArrayBySegmentTest() {
        ArraySum arraySum = new ArraySum();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Assert.assertEquals(arraySum.maxSubArrayBySegment(nums), 6);
    }

    @Test
    public void plusOneTest() {
        ArraySum arraySum = new ArraySum();
        Assert.assertArrayEquals(arraySum.plusOne(new int[]{1,2,3}), new int[]{1,2,4});
        Assert.assertArrayEquals(arraySum.plusOne(new int[]{4,3,2,1}), new int[]{4,3,2,2});
        Assert.assertArrayEquals(arraySum.plusOne(new int[]{1,2,9}), new int[]{1,3,0});
        Assert.assertArrayEquals(arraySum.plusOne(new int[]{9}), new int[]{1,0});
        Assert.assertArrayEquals(arraySum.plusOne(new int[]{9,9,9}), new int[]{1,0,0,0});

    }

    @Test
    public void maxProfitSingleTest() {
        ArraySum arraySum = new ArraySum();
        Assert.assertEquals(arraySum.maxProfitSingle(new int[]{7, 1, 5, 3, 6, 4}), 5);
        Assert.assertEquals(arraySum.maxProfitSingle(new int[]{7, 6, 4, 3, 1}), 0);
    }

    @Test
    public void maxProfitTest() {
        ArraySum arraySum = new ArraySum();
        Assert.assertEquals(arraySum.maxProfit(new int[]{7, 1, 5, 3, 6, 4}), 7);
        Assert.assertEquals(arraySum.maxProfit(new int[]{1,2,3,4,5}), 4);
        Assert.assertEquals(arraySum.maxProfit(new int[]{7, 6, 4, 3, 1}), 0);
    }

    @Test
    public void robTest() {
        ArraySum arraySum = new ArraySum();
//        System.out.println(arraySum.rob(new int[]{1,2,2,1}));
//        System.out.println(arraySum.rob(new int[]{2,1,1,2}));
        System.out.println(arraySum.rob(new int[]{1,2,3,1}));
    }

    @Test
    public void threeSumTest() {
        ArraySum arraySum = new ArraySum();
        int[] nums = {0,0,0,0,0};
        List<List<Integer>> lists = arraySum.threeSum(nums);
        System.out.println(lists);
    }
}