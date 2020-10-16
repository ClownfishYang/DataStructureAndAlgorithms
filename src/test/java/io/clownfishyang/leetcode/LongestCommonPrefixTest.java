package io.clownfishyang.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/11 14:05<br>
 */
public class LongestCommonPrefixTest {

    String[] strs1 = {"flower", "flow", "flight"};
    String[] strs2 = {"dog", "racecar", "car"};
    String v1 = "fl";
    String v2 = "";

    @Test
    public void searchTest() {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        Assert.assertEquals(longestCommonPrefix.verticalSearch(strs1), v1);
        Assert.assertEquals(longestCommonPrefix.verticalSearch(strs2), v2);
    }

    @Test
    public void horizontalSearchTest() {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        Assert.assertEquals(longestCommonPrefix.horizontalSearch(strs1), v1);
        Assert.assertEquals(longestCommonPrefix.horizontalSearch(strs2), v2);
    }

    @Test
    public void binarySearchTest() {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        Assert.assertEquals(longestCommonPrefix.binarySearch(strs1), v1);
        Assert.assertEquals(longestCommonPrefix.binarySearch(strs2), v2);
        Assert.assertEquals(longestCommonPrefix.binarySearch(new String[]{"a"}), "a");
    }
}