package io.clownfishyang.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/9/1 14:07<br>
 */
public class ArrayUtilTest {

    @Test
    public void rotateTest() {
        ArrayUtil arrayUtil = new ArrayUtil();
        int[] nums = {1,2,3,4,5,6,7};
        arrayUtil.rotate(nums, 6);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1,2,3,4,5,6,7};
        arrayUtil.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{-1,-100,3,99};
        arrayUtil.rotate(nums, 2);
        System.out.println(Arrays.toString(nums));

    }

    @Test
    public void moveZeroesTest() {
        ArrayUtil arrayUtil = new ArrayUtil();
        int[] nums = {1,0,3,0,5,0,7};
        arrayUtil.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void permuteTest() {
        ArrayUtil arrayUtil = new ArrayUtil();
        int[] nums;
        nums = new int[]{1,2,3};
        List<List<Integer>> res = arrayUtil.permute(nums);
        System.out.println(res);
    }

    @Test
    public void subsetsTest() {
        ArrayUtil arrayUtil = new ArrayUtil();
        int[] nums;
        nums = new int[]{1,2,3};
        List<List<Integer>> res = arrayUtil.subsets(nums);
        System.out.println(res);
    }
}