package io.clownfishyang.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/13 10:08<br>
 */
public class BaseComputeTest {

    @Test
    public void addBinaryTest() {
        BaseCompute baseCompute = new BaseCompute();
        Assert.assertEquals(baseCompute.addBinary("0", ""), "0");
        Assert.assertEquals(baseCompute.addBinary("", "1"), "1");
        Assert.assertEquals(baseCompute.addBinary("0", "0"), "0");
        Assert.assertEquals(baseCompute.addBinary("1", "0"), "1");
        Assert.assertEquals(baseCompute.addBinary("0", "1"), "1");
        Assert.assertEquals(baseCompute.addBinary("1", "1"), "10");
        Assert.assertEquals(baseCompute.addBinary("11", "1"), "100");
        Assert.assertEquals(baseCompute.addBinary("1", "11"), "100");
        Assert.assertEquals(baseCompute.addBinary("1010", "1011"), "10101");
        Assert.assertEquals(baseCompute.addBinary("1011", "1010"), "10101");
        Assert.assertEquals(baseCompute.addBinary("1111", "1111"), "11110");

    }

    @Test
    public void mySqrtTest() {
        BaseCompute baseCompute = new BaseCompute();
//        Assert.assertEquals(baseCompute.mySqrt(4), 2);
        Assert.assertEquals(baseCompute.mySqrt(8), 2);
//        Assert.assertEquals(baseCompute.mySqrt(16), 4);
    }
}