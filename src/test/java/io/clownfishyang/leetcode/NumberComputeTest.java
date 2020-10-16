package io.clownfishyang.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/9/7 17:57<br>
 */
public class NumberComputeTest {

    @Test
    public void hammingWeightTest() {


    }

    @Test
    public void reverseBitsTest() {
        NumberCompute numberCompute = new NumberCompute();
        int ret = numberCompute.reverseBits(0b00000010100101000001111010011100);
        System.out.println(Integer.toBinaryString(ret));
        System.out.println(Integer.toBinaryString(Integer.reverse(0b00000010100101000001111010011100)));
        System.out.println();
        ret = numberCompute.reverseBits(0b11111111111111111111111111111101 );
        System.out.println(Integer.toBinaryString(ret));
        System.out.println(Integer.toBinaryString(Integer.reverse(0b11111111111111111111111111111101)));
    }
}