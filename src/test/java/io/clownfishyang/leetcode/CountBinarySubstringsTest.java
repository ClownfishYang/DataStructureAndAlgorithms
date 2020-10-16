package io.clownfishyang.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/10 15:29<br>
 */
public class CountBinarySubstringsTest {

    @Test
    public void countBinarySubstringsTest() {
        CountBinarySubstrings count = new CountBinarySubstrings();
        Assert.assertEquals(count.linearCount("00110011"), 6);
        Assert.assertEquals(count.linearCount("10101"), 4);

        Assert.assertEquals(count.groupCount("00110011"), 6);
        Assert.assertEquals(count.groupCount("10101"), 4);
    }
}